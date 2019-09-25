#Implement Extension Points on Authentication Service

The extension points (ExternalJwtMapper and InternalJwtMapper) are useful interfaces that allow you to add custom behavior to your authentication service

---

## Instructions: Development environment setup

In order to setup the exercise you need **Edge Service**, **Registry Service**,  **BB External Token Converter Service** and **Exchange Rate Service**.

## Material provided

This repo contains the following modules

* exchange-rate-specification
* exchange-rate-service
* auth-service-extension-points

### Step 1: Start your platform services (if they are not running)

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wa3-setup) to start your platform services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started. Make sure that the authentication service is not there

### Step 2: Extension Point ExternalJwtMapper

Do you remember the first exercise? You needed a token to connect to TransferWise but in that exercise you just hardcoded for each request.
Now we are going to add that token as an external JWT claim using ExternalJwtMapper and retrieve it on the *exchange-rate-service* every time we execute a call to TransferWise sandbox

To do that, execute the following steps:

1. Go to **com.backbase.service.auth.extension.token.ExternalJWTMapperImpl** and solve the TODOs available there.
1. Since we added extra claim to the external token, we need to tell the token converter to map them to the internal token. Follow the section **3.Optionally, configure the claims mapping** from [this link in community](https://community.backbase.com/documentation/identity/1-1-0/oidc_token_converter_service)
1. Go to the ExchangeRateService class inside the Exchange Rate Service Module and solve the TODOs to retrieve the token from the claim 

### Step 3: Run the project

Inside `../exchange-rate-service` run:

```
mvn spring-boot:run
```

Inside `../auth-service-extension-points` run:

```
mvn spring-boot:run
```

### Step 4: Test the Service

1. Log in through the authentication service and try log in

	[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

1. Call the service. If you are able to see the currencies it means your exercise is working.

	[http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies](http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies)