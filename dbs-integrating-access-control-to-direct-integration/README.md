# How to apply extra security to a Direct Integration service using Access Control Capability

In the Direct Integration exercise, you created the Exchange Rate Service. Your service currently can be accessed by any user without any restriction. With Access Control capability you can apply fine-grained security levels for each user.

In this exercise, you will apply extra security to the Exchange Rate Service endpoints and setup permission for the user Peter and Jonathan from KPMG (created when setting up entitlements)

The end result is being able to access the endpoints only through users allowed in Access Control.

---
## Prerequisites (already done in previous exercises)

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/)

* Setting up entitlements:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/)
    
* The following services up and running

1. Platform
1. Access Control


### Step 1: Adding a business function to the database.

1. Insert into `accesscontrol_pandp_service`.`business_function` the following values:
    1. id: 2000
    1. function_code: manage.currencies
    1. function_name: Manage Currencies
    1. resource_code: Currencies
    1. resource_name: Currencies
    
1. Insert into `accesscontrol_pandp_service`.`business_function` the following values:
    1. id: 2001
    1. function_code: manage.exchange.rates
    1. function_name: Manage Exchange Rates
    1. resource_code: Rates
    1. resource_name: Rates

### Step 2: Adding a function privilege to the database

1. Insert into `accesscontrol_pandp_service`.`applicable_function_privilege` the following values:
    1. id: 1000
    1. business_function_name: Manage Currencies
    1. function_resource_name: Currencies
    1. privilege_name: view
    1. supports_limit: 0
    1. business_function_id: 2000
    1. privilege_id: 2

1. Insert into `accesscontrol_pandp_service`.`applicable_function_privilege` the following values:
    1. id: 1001
    1. business_function_name: Manage Exchange Rates
    1. function_resource_name: Rates
    1. privilege_name: view
    1. supports_limit: 0
    1. business_function_id: 2001
    1. privilege_id: 2

### Step 3: Create the Job Profile and Update Permissions for Peter

1. Download the postman collection located at extras folder [DBS Training - Integrating Direct Integration Service with Access Control 2.16.0.postman_collection](extras)

1. Create the body of the request `1. Create Job Profile for MSA of KPMG (Viewer of Currencies)`

`hint: You can use the body from the folder number 7 from the previous exercise. Make the adjustments to this exercise (changing the: name, description, functionId and assignedPriviledges)`

**be careful! PUT requests will update the entire object**

1. Update the body on the call `2. Assign Permission to Peter to (View All Currencies)` adding the job profile create in the previous request

`HINT: The dataGroupIds must remain empty` 

### Step 4: Create the Job Profile and Update Permissions for Jonathan


1. Create the body of the request `1. Create Job Profile for MSA of KPMG (Viewer of Exchange Rates)`

1. Update the body on the call `2. Assign Permission to Jonathan to (View All Exchange Rates)`

`HINT: The dataGroupIds must remain empty` 

### Step 5: Test if the step 3 and 4 worked

1. Login as Peter
1. Set the context for Peter
1. Execute the request `5. Check privileges view for Peter: Manage Currencies`. The response should be `200 OK` without body

1. Login as Jonathan
1. Set the context for Jonathan
1. Execute the request `5. Check privilege view for Jonathan: Manage Exchange Rates`. The response should be `200 OK` without body

### Step 6: Secure the service

Now that you have the Business Function, Privilege Function, Job Profile and the permissions Assigned to Peter and Jonathan, is time to secure the service.

Clone this repository into your machine and follow the TODO's inside the project.

### Step 7: Test the service

First, let's check if our service instance appears available in the Registry:

[http://localhost:8080/registry](http://localhost:8080/registry)

Log in through the authentication service using Peter, Peter

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

Hit the currency endpoint. [http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies](http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies)

Log in again through the authentication service using Jonathan, Jonathan 

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

Hit the rates endpoint. [http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates](http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates)

Try reaching different endpoints with diffrent users.
