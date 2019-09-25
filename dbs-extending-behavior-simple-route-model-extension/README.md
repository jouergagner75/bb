# Extending behaviour of existing capability using preHook

The goal of this exercise is to put together the Behavior extension and data model extension.

On the **first** exercise for contacts [https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-simple-route](https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-simple-route) you created a behavior extension with a `@PostHook` to enrich the response

On the **second** exercise for contacts [https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-data-model](https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-data-model) you added extra fields and one of these fields were `socialProfileLink`

The goal of this exercise is to create another behavior extension, this time a `@PreHook` for `CreateContactRouteBuilder` to validate if what is being passed in the `socialProfileLink` is a valid link.

## Prerequisites

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/)

* Now, for this exercise the platform and following capabilities must be up and running

1. Platform
1. Access Control
1. Contacts

## Step 1: Creating the PostHook

For this exercise we can reuse the project created on this exercise ->  [https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-simple-route](https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-simple-route)

1. Inside the same package that you used the previous exercise for behavior extension, create another class.
1. Create the behavior extension like you did in the first behavior extension exercise giving a unique name for `name inside @BehaviorExtension`
1. Find the `routeId` for the @BehaviorExtension inside `CreateContactRouteBuilder`
1. Create the `@PreHook` method. The data will be validated before we save it. The signature for this method must be `public void preHook(InternalRequestWrapper<Contact> internalRequestWrapper)`
1. Implement the business logic. You can use the `org.apache.commons.validator.routines.UrlValidator` to validate the URL
1. If the URL is not valid throw `com.backbase.presentation.contact.rest.spec.v2.contacts.BadRequestException`

## Step 2: Test the service

1. Inside the exercise root folder run 

`mvn clean install`

1. Go to the `target` folder and copy the jar file generated.

1. Go to [http://localhost:8081](http://localhost:8081) and stop the `contact-presentation-service`

1. Paste the copied jar inside `dbs/contact-manager/target/tomcat/webapps/contact-presentation-service/WEB-INF/lib`

1. Go back to [http://localhost:8081](http://localhost:8081) and start the `contact-presentation-service`

1. Execute the postman request again create a new contact and check if it fails with invalid URL.

