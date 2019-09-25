# Setting up Entitlements

This exercise will help you to setup Entitlements.



## Prerequisites (already done in previous exercises)

* Setting up the LDAP users

	For this exercise we are going to use a specific set of users that are not provided inside `platform/authentication-ldap/config/backbase/users.ldif`. Replace the entire content of the `users.ldif` by the ones provided [here](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/browse/files/users.ldif)

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/browse](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/browse)
    
* The following services up and running

1. Platform
1. Access Control
1. Product Summary

**Don't forget to add the original authentication-ldap back to the platform by uncommenting the modules and dependencies from the platform/pom.xml**

## Setup Entitlements

The following Postman Collection and environment file contains all of the REST calls you will need for this exercise: 

> Note: Below given postman environment file contains default host and port numbers. Please make sure host and port numbers are correct for services given in further section. If not, please make necessary changes in environment variables for host and port numbers.

- [entitlements.collection](files/entitlements.collection.json)
- [entitlements.environment](files/entitlements.environment.json)

## Steps

Analyse the json and execute the postman collection call in the order they are listed.

**Execute the requests one by one, because of the environment variables you have to wait for the response of each request**

You are going to do the following requests with the given collection.

1. Create the Legal Entity Hierarchy
    - Create Bank (root)
    - Create KPMG (under Bank)
    - Create Backbase (under Bank)
2. Create Users
    - Create bank user (admin)
    - Create KPMG user (Jonathan)
    - Create KPMG user (Peter)
    - Create KPMG user (Sandra)
    - Create KPMG user (Vanessa)
    - Create KPMG user (Albert)
3. Update External Service Agreement Id for Bank and KPMG
    - Get master service agreement for Bank
    - Set external service agreement id for Bank
    - Get master service agreement for KPMG
    - Set external service agreement id for KPMG
4. Create Entitlements Admins
    - Promote the Bank User and Jonathan as Entitlements Admin
5. Create Products
    - Create Product Catalogue with one product: Current Account
    - Create Arrangement (ACC1) for KPMG
    - Create Arrangement (ACC2) for KPMG
    - Create Arrangement (ACC3) for KPMG
    - Create Arrangement (ACC4) for Backbase
    - Create Arrangement (ACC5) for Backbase
    - Create Arrangement (ACC6) for Backbase
6. Create Data Groups
    - Create DG for MSA of KPMG (All Accounts)
7. Create Function Groups
    - Retrieve ID for available business functions in the system
    - Create Function Group for MSA of KPMG (Viewer of Product Summary and Transaction)
    - Create Function Group for MSA of KPMG (Viewer of Contacts)
8. Assign and Test Permissions to User (Custom Service Agreement)
	- Assign Permission to Peter to (View All Accounts on PS and Transactions)
	- Assign Permission to Peter to (View All Contacts)
	- Login as Peter
	- Set context for Peter
	- Check permissions for Peter for specific Business Function
	- Check permissions for Peter for specific Business Function and Privilege
	- Check permissions for Peter: List of Arrangements that Peter can see for given Business Function
9. Manage Custom Service Agreement
	- Create Service Agreement
	- Create FG for SA - KPMG/Backbase (Finance Officer)
	- Create DG for SA - KPMG/Backbase (Salaries)
10. Assign and Test Permissions to User (Custom Service Agreement)
	- Assign permissions to Sandra in SA between KPMG and Backbase
	- Login as Sandra
	- Set context for Sandra
	- Check permissions for Sandra for specific Business Function
	- Check permissions for Sandra for specific Business Function and Privilege
	- Check permissions for Sandra: List of Arrangements that Sandra can see for given Business Function
