# Extending behaviour of existing capability using pre/post hooks

This how-to guide describes the steps to extend capability behaviour using pre/post hooks in order to allow 
additional operations before and after out-the-box capability workflow.

For this exercise we will use a real world Backbase capability, contacts.

The Exercise will consist of four main steps: deploying contacts, data ingestion, and extending its 
default behaviour using hooks.

In this ex
## Prerequisites

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities)

* Now, for this exercise the platform and following capabilities must be up and running

1. Platform
1. Access Control
1. Contacts

* Increase the memory for the contact capability. Go to: `../cxs/dbs/contact-manager/.mvn/jvm.config` and change


    `-XX:MaxMetaspaceSize=322929K` and `-Xmx358286K`
   
    
    to
    
  
    `-XX:MaxMetaspaceSize=1G` and  `-Xmx1G`
    
Since **Contacts** is a capability we didn't start in previous exercises, run following command to setup database for 
this capability:

	mvn clean install -Pclean-database

## Step 1: Deploying contacts

In order to extend the behaviour of contacts using hooks, we have to first be able to deploy and examine its default 
behaviour. 
Run the `mvn blade:run` for the platform and capabilities described in the step *Prerequisites*.

Check the registry to verify that our services are working as expected :

* [http://localhost:8080/registry](http://localhost:8080/registry)

Next step is to initialize our system.

## Step 2: Data ingestion

For this exercise you are going to reuse the data created in the exercise for entitlements [https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/)

* Let's start off by understanding what we can re use from the previous training:
   
    * We created a bank called `BANK` and two customers `KPMG` and `Backbase` for it
    * We created `KPMG` users: `Jonathan`, `Peter` and `Sandra`

* In order to create a new contact in the contacts list for a user we need to:
    * Create a `Job Profile` (also called function group) for Contacts and give the privileges (view, create and edit)
     to this profile
    * Assign the `Job Profile` to a User.
    
* Import the [Postman collection](https://codebase.backbase.com/projects/TRBE/repos/dbs-extending-behavior-simple-route/browse/postman/DBS%20Training%20-%20Behaviour-extension-hooks.postman_collection.json) that comes with this project into your Postman tool.

* Apply the step 1:
   
    * Step 1 - Create a `Job Profile` called `Manage Contacts for KPMG`
    
* **Modify** the PUT request to add the previously created Job Profile on the step 2 and execute it
    
    * Step 2 - Assign the `Job Profile (Manage Contacts for KPMG)` to `Peter` (KPMG User)

* Now everything is set to create a new contact. Execute Step 3 to 5 to create a new contact `John Doe` in `Peter`'s contact list.

* Execute step 6 to retrieve all contacts in order to verify that new contact is in the contacts list.

All done ! We have a fully working and initialized system under which we can create a new contact. Now let's extend it.

## Step 3: Behaviour extension using post-hook

Go to our documentation available in [Community -> Documentation -> Digital Banking Services -> Reference -> Contacts
 reference](https://community.backbase.com/documentation/DBS/2-16-0/contacts_reference) and check the extension points available.

Now that we have seen the routes, let's extend default behaviour of `ListContactRouteBuilder` route (we will enrich the response) by configuring and implementing a custom `@PostHook` endpoint. 

### Generating the service extension project

We can easily use service extension archetype to generate our extension project:

```
mvn archetype:generate \
  -DarchetypeArtifactId=service-extension-archetype \
  -DarchetypeGroupId=com.backbase.archetype \
  -DarchetypeVersion=8.2.2 \
  -DgroupId=com.backbase.presentation.contact.academy \
  -DartifactId=contact-presentation-service-extension \
  -Dpackage=com.backbase.presentation.contact.academy \
  -DdbsVersion=2.16.0 \
  -DserviceArtifactId=contact-presentation-service \
  -DserviceGroupId=com.backbase.dbs.contact \
  -DrouteBuilderToExtend=com.backbase.presentation.contact.route.CreateContactRouteBuilder \
  --batch-mode
```
**The `-Dpackage` will be used for the generated classes. This must start with `com.backbase.presentation.contact` to match with the package structure of the contacts capability. This is important because otherwise the extension will not be loaded.**


The generated extension project contains the following example classes:

1. `CustomEndpoints` - consumer implementation of actual pre/post hook endpoints and replacement route endpoint 
1. `CustomExtendingRouteBuilder` - extends ootb `CreateContactRouteBuilder` to allow configuring pre/post hooks.
1. `CustomReplacingRouteBuilder` - new `ExtensibleRouteBuilder` to be used for replacing/overriding the complete ootb route with a custom one.
1. `ExampleBehaviorExtension` - Simpler way to override pre and post hooks

**Since for this exercise we are doing extension of CreateContactRouteBuilder using the simplest way for pre hook, please delete `advanced` package:**

### Implementation of PostHook endpoint

Notice that auto generated `ExampleBehaviorExtension` already has `@PreHook` and `@PostHook` methods.

This exercise will work with `@PostHook` for now. Let's understand what we need to do

On successful GET Contacts request, the response consists of available user's contact items as shown  below:

````
[
    {
        "id": "757d9ec9-aeb5-4f4e-bfd6-29cd4a7df232",
        "name": "John Doe",
        "alias": "John",
        "category": "Employee",
        "contactPerson": "Jane Doe",
        "phoneNumber": "055512345678",
        "emailId": "john@example.com",
        "addressLine1": "Backbase enterprise",
        "addressLine2": "",
        "streetName": "Jacob Bontiusplaats 9",
        "town": "Amsterdam",
        "postCode": "1018 LL",
        "countrySubDivision": "North Holland",
        "country": "NL",
        "accessContextScope": "USER",
        "activeStatus": "ACTIVE",
        "accounts": [
            {
                "name": "Saving account",
                "alias": "Savings",
                "IBAN": "FI2112345600000785",
                "bankName": "Test Bank",
                "bankAddressLine1": "Test Bank Co",
                "bankAddressLine2": "",
                "bankStreetName": "Jodenbreestraat 96",
                "bankTown": "Amsterdam",
                "bankPostCode": "1011NS",
                "bankCountrySubDivision": "North Holland",
                "bankCountry": "NL",
                "accountHolderAddressLine1": "Backbase enterprise",
                "accountHolderAddressLine2": "",
                "accountHolderStreetName": "Jacob Bontiusplaats 9",
                "accountHolderTown": "Amsterdam",
                "accountHolderPostCode": "1018 LL",
                "accountHolderCountrySubDivision": "North Holland",
                "accountHolderCountry": "NL"
            }
        ]
    }
]
````

By implementing a new behaviour extension for the default route `ListContactRouteBuilder` using the PostHook endpoint we will add a general `description` property in `additions` for 
each retrieved contact. 

The end result should look like the response below. Check the `description` property inside `additions`.

````
{
        "id": "757d9ec9-aeb5-4f4e-bfd6-29cd4a7df232",
        "name": "John Doe",
        "alias": "John",
        "category": "Employee",
        "contactPerson": "Jane Doe",
        "phoneNumber": "055512345678",
        "emailId": "john@example.com",
        "addressLine1": "Backbase enterprise",
        "addressLine2": "",
        "streetName": "Jacob Bontiusplaats 9",
        "town": "Amsterdam",
        "postCode": "1018 LL",
        "countrySubDivision": "North Holland",
        "country": "NL",
        "accessContextScope": "USER",
        "activeStatus": "ACTIVE",
        "additions": {
            "description": "Contact John Doe from category Employee with phone number 055512345678, email address john@example.com and account in bank Test Bank with IBAN FI2112345600000785"
        },
        "accounts": [
            {
                "name": "Saving account",
                "alias": "Savings",
                "IBAN": "FI2112345600000785",
                "bankName": "Test Bank",
                "bankAddressLine1": "Test Bank Co",
                "bankAddressLine2": "",
                "bankStreetName": "Jodenbreestraat 96",
                "bankTown": "Amsterdam",
                "bankPostCode": "1011NS",
                "bankCountrySubDivision": "North Holland",
                "bankCountry": "NL",
                "accountHolderAddressLine1": "Backbase enterprise",
                "accountHolderAddressLine2": "",
                "accountHolderStreetName": "Jacob Bontiusplaats 9",
                "accountHolderTown": "Amsterdam",
                "accountHolderPostCode": "1018 LL",
                "accountHolderCountrySubDivision": "North Holland",
                "accountHolderCountry": "NL"
            }
        ]
}
````

### Let's start the exercise

1. Add a unique name to the @BehaviorExtension
1. Find the `routeId` for the @BehaviorExtension inside `ListContactRouteBuilder`
1. Remove the `@PreHook` method. The data will be enriched after we fetch it, this means using the `@PostHook`
1. Change the signature of the `@PostHook` to `public void postHookListContact(ContactListContainer contactListContainer)`
1. Iterate through each element of the contactListContainer and add to the `additions` of each one of them the following String (replacing %s)
`Contact %s from category %s with phone number %s, email address %s and account in bank %s with IBAN %s`
Replace the `%s` by the following attributes: `name`,`category`,`phoneNumber`,`emailId`,`bankName`, `iban`

### Test the service

1. Inside the exercise root folder run 

`mvn clean install`

1. Go to the `target` folder and copy the jar file generated.

1. Go to [http://localhost:8081](http://localhost:8081) and stop the `contact-presentation-service`

1. Paste the copied jar inside `dbs/contact-manager/target/tomcat/webapps/contact-presentation-service/WEB-INF/lib`

1. Go back to [http://localhost:8081](http://localhost:8081) and start the `contact-presentation-service`

1. Execute step 6 to retrieve all contacts and check the `additions` field
