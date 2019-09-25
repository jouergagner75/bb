# How to ingest Products, Arrangements, and Transactions using out-of-the-box DBS Integration Services

This how-to guide describes the steps to ingest legal entities, products, arrangements, and transactions using out of the box integration services.

## Prerequisites

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/browse](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-existing-capabilities/browse)

* Setting up entitlements:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/browse](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/browse)

* The following services up and running

1. Platform
1. Access Control
1. Product Summary
1. Transactions

Remember to run (**only if you are running for the first time, if you run this command for the previously used capabilities you will have to do the exercise for entitlements again**):

	mvn clean install -Pclean-database

before running

	mvn blade:run

## Postman Collection

The following Postman Collection and environment file contains all of the REST calls you will need for this exercise:

* [ingestion.postman_collection](postman/dbs-ingestion.postman_collection)

Note: Above given postman environment file contains default host and port numbers. Please make sure host and port numbers are correct for services given in further section. If not, please make necessary changes in environment variables for host and port numbers.


## Configuration previously executed

In the exercise [https://bitbucket.org/backbase/dbs-setting-up-entitlements](https://bitbucket.org/backbase/dbs-setting-up-entitlements) you created some data that are required by the Transactions capability, they are:

### 1. Legal Entities

You created legal entities at the first step (1.)

* `BANK` legal entity as the root entity of the hierarchy
* `KPMG` legal entity as a child of `BANK`
* `Backbase` legal entity as a child of `BANK`

You can validate in the database running the following query:
	
	SELECT * FROM accesscontrol_pandp_service.legal_entity;

### 2. A Product

You created a product at the step (5.) 

*  `Current Account` product

You can validate in the database running the following query:
	
	SELECT * FROM arrangement_pandp_service.product;

### 3. Arrangements

And finally you created arrangements, also in the step 5.

* `A01, A02 and A03` as the Arrangements for KPMG
* `A04, A05 and A06` as the Arrangements for Backbase

You can validate in the database running the following query:

	SELECT * FROM arrangement_pandp_service.arrangement;

### 4. Transactions

Now, in this exercise you are going to ingest data through the out-of-the-box endpoint available in the transactions-integration service. These are the transactions to be ingested:

* `TV @ Neptun820` as a transaction for the Arrangement `A01`
* `Online Shop` as a transaction for the Arrangement `A01`
* `Restaurant` as a transaction for the Arrangement `A02`

Execute the only POST call available inside the POSTMAN collection and then validate it in the database
	
	SELECT * FROM transaction_persistence_service.fin_txn;
	
