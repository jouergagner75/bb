# How to implement a custom integration service using scheduled jobs with transactions capability in DBS

Integration service is a micro-service inside DBS architecture that communicates with the core banking system.

Let's say customer is used to have a REST endpoint to provide transactions for transactions capability.

In this training exercise, you will create a custom integration service that consumes transactions every 2 hours from an endpoint and sends them to presentation service to store in database.

To simulate 3rd party system, you will use this [open api](https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions). JSON format is different so you will **transform** transactions.

---

---
## Instructions: Development environment setup

You will create a custom integration service and use it with Transactions capability to store transactions in your database.

In order to setup the exercise you need platform services, access-control, product summary and transactions capabilities up and running.

Besides you need to setup your database to create transactions.


## Prerequisites

* Setting up existing capabilities:

	[https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/browse](https://codebase.backbase.com/projects/TRBE/repos/dbs-setting-up-entitlements/browse)

* The following services up and running

1. Platform
1. Access Control
1. Product Summary
1. Transactions

### Step 1: Previously ingested data

For this exercise you need to have Legal Entities, products and arrangements to create transactions.

All this data was already created because of the exercise [dbs-setting-up-entitlements](https://bitbucket.org/backbase/dbs-setting-up-entitlements/src/master/) 

### Step 2: Cloning projects

This microservice was created using **integration-service-archetype** from Service SDK. You don't have to create the whole project again.

Clone the repository into your machine.

### Step 3: Solve TODO's

**Follow the TODO's** inside the project.

### Step 4: Run the service
	
Run the following command inside the root of your project:

	mvn spring-boot:run

### Step 5: Test the service

Check if transactions was created in the database.
	
	SELECT * FROM transaction_persistence_service.fin_txn;






