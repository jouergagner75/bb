# Extending behaviour of existing capability

This how-to guide describes the steps to create a behaviour extension on an existing capability.
Capability behaviour can be extended on multiple points in order to:

1. perform operations before and after out-the-box capability workflow - configure/implement **pre-hook** and 
**post-hook** endpoints
1. inject modifications into the workflow without modifying the out-the-box capability - configure/implement endpoint
(**interceptSendToEndpoint**) 
that intercepts the workflow when an exchange is about to be sent to a given endpoint
1. replace complete out-the-box capability workflow with custom one - provide a new **ExtensibleRouteBuilder** 
implementation using the same route ID as the route we wish to replace
   
For this exercise we will use a real world backbase capability, payments. 
The Exercise will consist of four main steps: deploying payments, ingesting data, extending its default behaviour and finally the exercise

## Prerequisites

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities)

* Disable a few optional capabilities to save memory. Go to: `..dbs/payments/payment-order-presentation-service/application.yml` and add the following piece of code

```
backbase:
  payments:
    limits:
      enabled: false
    audit:
      enabled: false
```

* Increase the MaxMetaSpace for the payments capability. Go to: `../cxs/dbs/payments/.mvn/jvm.config` and change


    `-XX:MaxMetaspaceSize=326328K` and `-Xmx354375K`
   
    
    to
    
  
    `-XX:MaxMetaspaceSize=1G` and  `-Xmx1G`


* Now, the following platform and capabilities must be up and running

1. Platform
1. Access Control
1. Product Summary
1. Payments

Remember to run (*Only for capabilities you didn't start in the previous exercise, otherwise you will erase the entire database*):

	mvn clean install -Pclean-database

before running the capabilities with

	mvn blade:run
    
Check the registry to verify that our services are working as expected:

* [http://localhost:8080/registry](http://localhost:8080/registry)

## Step 1: Deploying payments

In order to extend the behaviour of payments, we have to first be able to deploy and examine its default behaviour. 
Run the `mvn blade:run` for the platform and capabilities described in the step *Prerequisites*

Next step is to initialize our system.

## Step 2: Data ingestion

For this exercise you are going to reuse the data created in the exercise for entitlements [https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements)

* Let's start off by understanding what we can re use from the previous training:
   
    * We created a bank called `BANK` and two customers `KPMG` and `Backbase` for it
    * We created a product `Current Account` (also known as checking account in North America)
    * Then created 6 arrangements `ACC1, ACC2, ACC3` for KPMG and `ACC4, ACC5, ACC6` for Backbase
    * And we grouped the arrangements for KPMG and called that group `All accounts`

* In order to make a payment we need:
    * Create a `Job Profile` (also called function group) for Payments and give the privileges (view, create and edit) to this profile
    * Create a `Product Group` to group the arrangements. This `Product Group` was already created for KPMG (All Accounts) and we are going to reuse it.
    * Assign the `Job Profile` and `Product Group` to a User.
    
* Import the [Postman collection](https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-extensible-route/browse/postman/DBS%20Training%20-%20Behaviour.postman_collection.json) that comes with this project into your Postman tool.
* Apply the steps from 1 and 3 which will in a nutshell do the following:
   
    * Step 1 - Create a `Job Profile` called `Manage SEPA CT Payments for Amsterdam`
    * Step 2 - Create a `Product Group (All Accounts)` - You already executed this in the setting up 
    entitlements exercise, just check it
    * Step 3 - Assign the `Job Profile (Manage SEPA CT Payments for Amsterdam)` and `Product Group (All Accounts)` to Peter (KPMG User)

* Now everything is set to make payments. Execute Step 4 to 7 to make a Payment

All done ! We have a fully working and initialized system under which we can make a payment. Now let's extend it.

## Step 3: Behaviour extension
Go to our documentation available in [Community -> Documentation -> Digital Banking Services -> Use and extend DBS -> Use payments](https://community.backbase.com/documentation/DBS/2-16-0/payments_understand)
and check the extension points available.

Now that we have seen the routes, same request should give different result once we extend its default behaviour.
Notice that on the original payment service post call we are making a high priority payment with user. 

In this exercise, let's modify create payment workflow to limit the user's capability to make a high priority 
payment by intercepting the route
`DIRECT_PAYMENT_VALIDATE`

### Generating the service extension project

We can easily use, service extension archetype to generate our extension project:

```
mvn archetype:generate \
  -DarchetypeArtifactId=service-extension-archetype \
  -DarchetypeGroupId=com.backbase.archetype \
  -DarchetypeVersion=8.2.2 \
  -DgroupId=com.backbase.academy.payments \
  -DartifactId=extension-example \
  -Dpackage=com.backbase.dbs.payment \
  -DdbsVersion=2.16.0 \
  -DserviceArtifactId=payment-order-presentation-service \
  -DserviceGroupId=com.backbase.dbs.paymentorder \
  -DrouteBuilderToExtend=com.backbase.dbs.payment.services.configuration.routes.InitiatePaymentOrderRoute \
  --batch-mode
```

You can change the values for `groupId` and `artifactId`. These will be used for the pom.xml file that will be generated.   

The `package` will be used for the generated classes. This must be `com.backbase.dbs.payment` to match with the package structure of the payment order capability.
This is important because otherwise the extension will not be loaded.   

Every information with `service` prefix is a direct reference to the service that we are extending.

The generated extension project contains the following example classes:

1. `CustomExtendingRouteBuilder` - extends out-of-the-box `InitiatePaymentOrderRoute` to allow configuring pre/post hooks (from SimpleExtensibleRouteBuilder) or interceptSendToEndpoint (from ExtensibleRouteBuilder).

    Note: You can check that there are two methods on this class (configurePreHook and 
    configurePostHook) auto generated for you. But for our exercise we won't use them because the InitiatePaymentOrderRoute has multiple routes
    and doesn't provide any implementation for these hooks. We will use a feature from camel called interceptSendToEndpoint. It will allow us to intercept more than one endpoint, as you will see in this exercise    

1. `CustomEndpoints` - consumer implementation of pre/post hook endpoints created automatically

1. `CustomReplacingRouteBuilder` - An example of entirely replacing the out-of-the-box Camel RouteBuilder to provide completely different behavior.

1. `ExampleBehaviorExtension` - An example of how to provide a behavior extension using annotations.


**For this exercise we will replace all the classes generated automatically for the sake of simplicity, so please delete all generated classes.**

And that's it. We are ready to build our extension.

Note: Feel free to create a faulty service extension project and examine the effects of what it does. Any faulty references to the service parameters would result in compile errors.

### Implementation of extension

Let's add a new endpoint that will have our additional logic.
Notice this is absolutely the same route definition with the only exception of having an additional interceptor to add our behaviour. This addition would trigger the extra behaviour on custom endpoints to fuel our example. Let's all implement the behaviour:

```
package com.backbase.dbs.payment.route;

import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.dbs.payment.context.ExtendedInternalRequest;
import com.backbase.dbs.payment.payment.model.CreatePaymentRequestDto;
import com.backbase.dbs.presentation.paymentorder.rest.spec.v2.paymentorders.InitiatePaymentOrder;
import com.backbase.dbs.presentation.paymentorder.rest.spec.v2.paymentorders.ValidatedPaymentOrder;
import org.apache.camel.Consume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoints {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomEndpoints.class);

    public static final String VALIDATION_INTERCEPTOR = "direct:my.custom.payment.validate.interceptor";

    @Consume(uri = VALIDATION_INTERCEPTOR)
    public void extraValidation(ExtendedInternalRequest<CreatePaymentRequestDto> internalRequest) {
        LOGGER.info("======== In custom endpoint for validation ========");
        InitiatePaymentOrder initiatePaymentOrder = internalRequest.getData().getInitiatePaymentOrder();
        if ("peter".equalsIgnoreCase(internalRequest.getExtendedContext().getUserName()) &&
            initiatePaymentOrder.getInstructionPriority().equals(ValidatedPaymentOrder.InstructionPriority.HIGH)) {
            throw new BadRequestException("This user is not allowed to make high priority payment requests");
        }
    }

}
```

Let's add a new route definition that extends the current route definition on payments:

```
package com.backbase.dbs.payment.route;

import com.backbase.dbs.payment.services.configuration.routes.InitiatePaymentOrderRoute;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomExtendingRouteBuilder extends InitiatePaymentOrderRoute {

    @Override
    public void configure() throws Exception {
        interceptSendToEndpoint(DIRECT_PAYMENT_VALIDATE)
            .to(CustomEndpoints.VALIDATION_INTERCEPTOR);

        super.configure();
    }

}
```

Done ! In each payment, on top of the default behaviour, our validation would also kick in and check for the user to not allow high priority payments. Let's test it, on the extension project folder:

```
mvn clean install
```

In order to test it follow these steps:

1. Go to `../extension-example/target/` and copy the file `extension-example-1.0.0-SNAPSHOT.jar`

1. Go to `../dbs/payments/target/tomcat/webapps/payment-order-presentation-service/WEB-INF/lib` and paste the `extension-example-1.0.0-SNAPSHOT.jar`

1. Go to [http://localhost:8089](http://localhost:8089) and stop and start the payment-order-presentation-service

1. Once our service is up and running, let's finally run the step 7 again on our postman call (authenticate as Peter first and Post a Payment). We will see that the call is no longer allowed in the sense that user is not allowed to make a high priority payment call:

		{
		    "message": "This user is not allowed to make high priority payment requests"
		}

1. We can change the field

		"instructionPriority": "HIGH"

	to

		"instructionPriority": "NORM"

	on the postman collection to test whether the system would accept a normal priority call from the user.

All done ! We have implemented our first behaviour extension, on a real service, end to end.

## Step 4 Exercise

Using the techniques we have covered, can you implement another behaviour extension that enrich the payment information?

When posting a payment we have this information in the remittance section:

````
    ... },
          "remittanceInformation": "Salary",
          "endToEndIdentification": "5e1a3da132cc"
        }
    
````

In this exercise you will enrich the 'remittanceInformation' and change the value from `Salary` to: `"Salary payment for $NameOfTheCreditor"`.

Hint: The route is similar to the one used to validate the payment.

( For the exercise we can keep it simple and assume that a salary payment can be deduced by the remittance information text to contain the word `Salary` in it. Trigger the POST payment call to create a new payment with the new remittance information and then execute the GET payments to validate your exercise )
