# How to implement a custom integration service using transactions capability in DBS

Integration service is a micro-service inside DBS architecture that communicates with the core banking system.

Let's say customer is using transactions capability and decided to provide transactions using JMS Queue.

In this training exercise, you will create a custom integration service that consumes transactions from  JMS Queue and sends them to presentation service to store in database.

To simulate 3rd party system, you will use Active MQ web console. With this tool you will send sample transactions to a queue.

---
## Instructions: Development environment setup

You will create a custom integration service and use it with Transactions capability to store transactions in your database.

In order to setup the exercise you need platform services, access-control, product summary and transactions capabilities up and running.

Besides you need to setup your database to create transactions.


## Prerequisites

* Setting up existing capabilities:

	[https://bitbucket.org/backbase/dbs-e01-setting-up-existing-capabilities](https://bitbucket.org/backbase/dbs-e01-setting-up-existing-capabilities)

* The following services up and running

1. Platform
1. Access Control
1. Product Summary
1. Transactions

### Step 1: Previously ingested data

For this exercise you need to have Legal Entities, products and arrangements to create transactions.

All this data was already created because of the exercise [dbs-e02-setting-up-entitlements](https://bitbucket.org/backbase/dbs-e02-setting-up-entitlements/src/master/)

### Step 2: Cloning projects

This microservice was created using **integration-service-archetype** from Service SDK. 

**Clone the repository into your machine and follow the TODO's inside the project.**

### Step 3: Run the service
	
Run the following command inside the root of your project:

	mvn spring-boot:run

### Step 4: Test the service
	
1. ActiveMQ Console
	
	*  Go to [http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp) to access ActiveMQ web console.
	*  Provide credentials, if needed:
		*  Username = admin
		*  Password = admin
	
1. Send a message to the JMS queue

	* Look for the JMS queue of the *transactions-custom-integration*
	* Click **Send** link from the menu. Destination will be **transactions-custom-integration**
	* Provide a transactions JSON like this as the JMS body:

			{
                "transactions": [
                {
                    "externalId": "0000000000000101",
                    "externalArrangementId": "A01",
                    "reference": "BCA-123445",
                    "description": "Your first transaction description",
                    "typeGroup": "Payment",
                    "type": "SEPA CT",
                    "bookingDate": 1523955805000,
                    "valueDate": 1531818205000,
                    "amount": 820,
                    "currency": "EUR",
                    "creditDebitIndicator": "DBIT",
                    "category": "testCategory",
                    "instructedAmount": 321.2,
                    "instructedCurrency": "USD",
                    "currencyExchangeRate": 2.2,
                    "counterPartyName": "Pluto820",
                    "counterPartyAccountNumber": "4820"
                },
                {
                    "externalId": "0000000000000102",
                    "externalArrangementId": "A01",
                    "reference": "BJK-190300",
                    "description": "Transfer fee sample description",
                    "typeGroup": "Payment",
                    "type": "SEPA DD",
                    "bookingDate": 1521450205000,
                    "valueDate": 1526720605000,
                    "amount": 1220,
                    "currency": "USD",
                    "creditDebitIndicator": "DBIT",
                    "category": "transferCategory",
                    "instructedAmount": 2321.9,
                    "instructedCurrency": "EUR",
                    "currencyExchangeRate": 2.1,
                    "counterPartyName": "BJK1903",
                    "counterPartyAccountNumber": "1903"
                 }
                 ,
                 {
                    "externalId": "0000000000000103",
                    "externalArrangementId": "A02",
                    "reference": "KLM-124354",
                    "description": "KLM transaction for your flight",
                    "typeGroup": "Fees",
                    "type": "International payment",
                    "bookingDate": 1521018205000,
                    "valueDate": 1529226205000,
                    "amount": 490,
                    "currency": "TRY",
                    "creditDebitIndicator": "CRDT",
                    "category": "flightCategory",
                    "instructedAmount": 982.4,
                    "instructedCurrency": "EUR",
                    "currencyExchangeRate": 4.2,
                    "counterPartyName": "KL1903",
                    "counterPartyAccountNumber": "5912"
                 }
               ]
            }


1. Check if transactions was created in the database.
	
		SELECT * FROM transaction_persistence_service.fin_txn;






