# Create microservices using Backbase Service SDK

Ok, the last exercise was just a warm-up this is the real deal. This is as close as you can get in this short training to what our consultants do on day-to-day basis.

Your job here is to develop a new direct integration service from the ground. This means defining the specification, the schemas, the service etc. (You will probably want to use the last exercise as reference)

What are we connecting to? 

The purpose of this exercise is to provide *Exchange Rate* service to our widgets and for that we will connect our service to [TransferWise's API](https://api-docs.transferwise.com/).

In a nutshell, this is what you will do in this exercise

## Part 1: Working on the contract

1. Create the specification project through SSDK's archetype
1. Then create the RAML specification file and the schemas
1. And finally generate the Java sources from it using our maven plugin

## Part 2: Working on the service

1. Generate the microservice with Backbase Service SDK: Direct Integration Service. (This service will be the implementation for the specification)
1. Add the specification dependency to your service
1. Fulfill the contract by connecting to the TransferWise's API, retrieving the data and parsing it to the specification. You will need to create the necessary classes for that (domain, services and converters)
1. Test your service

---
# Setup
Since we have a limited time, we will guide you in a few steps

## Setup account to the external service

1. Go to [TransferWise Sandbox](https://sandbox.transferwise.tech/register) and create an account
1. [Login to TransferWise](https://sandbox.transferwise.tech/login)
1. Create an API Token by accessing the [settings](https://sandbox.transferwise.tech/user/settings) 
1. Check their [documentation](https://api-docs.transferwise.com/) to learn how make requests, more precisely the [Exchange Rates Endpoints](https://api-docs.transferwise.com/#exchange-rates)

## Setup Backbase Local development environment 

In order to setup the exercise you need **platform services** (services located inside platform folder).

### Step 1: Start your platform services

    Note:   If they are already running you can skip this step.

1. Follow [this guide](https://codebase.backbase.com/projects/TRCO/repos/cxs-wa3-setup/) to start your platform and CXS services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started.

# Developing the project

We will need to have two endpoints available on this project for our Front-end friends

1. `/v1/exchange/currencies` that will map the information from [transferwise available currencies](https://api-docs.transferwise.com/#borderless-accounts-get-available-currencies). 

Execute a curl request to see what this endpoint will return 

```
curl -H 'Authorization: Bearer <your token here>' 'https://api.sandbox.transferwise.tech/v1/borderless-accounts/balance-currencies'
```

Since we are developing the contract, we previously agreed on how the JSON response should look like, this is what the Front-end team is expecting from your endpoint (compare it with the curl request)

````

[
  {
    "code": "EUR"
  },
  {
    "code": "GBP"
  },
  {
    "code": "USD"
  }
]

````


1. `/v1/exchange/rates?source=EUR&target=USD&from=2019-03-31&to=2019-04-30` that will map the information from [transferwise exchange rates](https://api-docs.transferwise.com/#exchange-rates). 

```
curl -H 'Authorization: Bearer <your token here>' 'https://api.sandbox.transferwise.tech/v1/rates?source=EUR&target=USD&from=2019-07-01T00:00:00+00:00&to=2019-07-01T23:59:59+00:00'
```
**Note that to request the exchange rate to transferwise the time is needed e.g `from=2019-07-01T00:00:00+00:00&to=2019-07-01T23:59:59+00:00`. The FE will only send the dates, like this: `from=2019-07-01&to=from=2019-07-01` it is a BE requirement to add the time to the request.**

Again, this is what the Front-end team is expecting from your endpoint (compare it with the curl request)

````

[
  {
    "rate":1.1279,
    "source":"EUR",
    "target":"USD",
    "time":"2019-03-13T00:00:00+0000"
  },
  {
    "rate":1.12504,
    "source":"EUR",
    "target":"USD",
    "time":"2019-03-12T00:00:00+0000"
  },
  {
    "rate":1.12235,
    "source":"EUR",
    "target":"USD",
    "time":"2019-03-11T00:00:00+0000"
  },
  {
    "rate":1.12341,
    "source":"EUR",
    "target":"USD",
    "time":"2019-03-10T00:00:00+0000"
  }
  ...
  ]
 
````


## Step 1: Create a specification project

1. Inside your project (the one you downloaded from [start-training.backbase.com](https://start-training.backbase.com) create a folder called `direct-integration-services`
1. Navigate to that folder on your terminal
1. Inside `direct-integration-services` use the archetype below to generate your specification project.

		mvn archetype:generate \
          -DarchetypeArtifactId=raml-specifications-archetype \
          -DarchetypeGroupId=com.backbase.archetype \
          -DarchetypeVersion=8.2.2 \
          -DservicePackageName=com.backbase.training \
          -DgroupId=com.backbase.training \
          -DartifactId=exchange-rate-specification \
          --batch-mode
          
1. Create the JSON Schemas based on the JSON example from the previous section.

1. Create the RAML specification for those 2 endpoints (`/v1/exchange/currencies` and `/v1/exchange/rates?source=EUR&target=USD&from=2019-07-01&to=2019-07-30`)


```
Usually most people don't have experience writing RAML specification files, so here are some advices

Check this documentation link https://github.com/raml-org/raml-spec/blob/master/versions/raml-10/raml-10.md

If that is not enough, check the RAML used by DBS team. You can search through intelliJ or go to http://repo.backbase.com and search for the specifications, for example *transaction-presentation-spec*

```

1. Run `mvn clean install` and check if the specification was created correctly by going to the `target/generate-sources` folder.


## Step 2: Create the Direct Integration Service

1. Go to the folder you created in the previous step `direct-integration-services` and on the terminal type

		mvn archetype:generate \
          -DarchetypeArtifactId=direct-integration-service-archetype\
          -DarchetypeGroupId=com.backbase.archetype \
          -DarchetypeVersion=8.2.2 \
          -DservicePackageName=com.backbase.training \
          -DgroupId=com.backbase.training \
          -DartifactId=exchange-rate-service \
          --batch-mode

1. At this point your project structure should look like this
        
        -demo
          --cx6
          --dbs
          --platform
          --direct-integration-services
              ---exchange-rate-service
              ---exchange-rate-specification
	
1. Add specification dependency to your microservice.

		<dependency>
			<groupId>com.backbase.training</groupId>
			<artifactId>exchange-rate-specification</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>
		
1. Your microservice will use internal token, so add the below property to your environment variables. 

	* name: `SIG_SECRET_KEY`
	* value: `JWTSecretKeyDontUseInProduction!`

	You can either use the maven plugins to set this value.

	    <plugin>
	        <groupId>org.codehaus.mojo</groupId>
	        <artifactId>properties-maven-plugin</artifactId>
	        <version>1.0.0</version>
	        <executions>
	            <execution>
	                <goals>
	                    <goal>set-system-properties</goal>
	                </goals>
	                <configuration>
	                    <properties>
	                        <property>
	                            <name>SIG_SECRET_KEY</name>
	                            <value>JWTSecretKeyDontUseInProduction!</value>
	                        </property>
	                    </properties>
	                </configuration>
	            </execution>
	        </executions>
	    </plugin>
	    
1. Go to your projects `application.yml` file and change the registry port to `8080`.

1. Delete the entire package example that was generated automatically

1. Provide the implementation for the `exchange-rate-specification` using the technologies you know. Check the previous exercise `atm-location-service` to have a reference point on how your service should look like.


### Step 3: Run your microservice

Move into your `exchange-rate-service` folder and run the command:

	mvn spring-boot:run	

### Step 5: Test your service

1. First, let's check if our service instance appears available in the Registry:

	[http://localhost:8080/registry](http://localhost:8080/registry)

1. Log in through the authentication service:

	[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

1. Hit the service

	[http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies](http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/currencies)
    
    [http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates?source=EUR&target=USD&from=2019-03-31&to=2019-04-30](http://localhost:8080/gateway/api/exchange-rate-service/v1/exchange/rates?source=EUR&target=USD&from=2019-03-31&to=2019-04-30)
	
You should see the body of the response like the examples provided in the beginning of this README

### Step 6: Integrate the service with real widgets

1. Download the extras folder from this repo and navigate to it from your your terminal
1. Execute the following command to import the widget into your Enterprise Catalog **Make sure you have CXS services running at [http://localhost:9080](http://localhost:9080)**

```
java -jar cx6-import-tool-cli-6.1.1.jar --import banking-app.zip --auth-url=http://localhost:8080/gateway/api/auth/login --target-ctx=http://localhost:8080/gateway/api/provisioning --username=admin --password=admin
```

1. Lets enable mocks first
    1. Open the browser console and enter the following command on the console tab to **enable** mocked data `localStorage.setItem("enableMocks",true);`
1. Create a new Experience and open it
1. Go to the master page and change the property **based on** from `Web-basic` to `Lean Page`
1. Go to Experience Catalog and import the following widgets
    1. Peachtree Bank WA3 App
    1. ExchangeRateWidget Widget
1. Go back to your home page and do the following steps
    1. First drag-n-drop the `Peachtree Bank WA3` App into the page
    1. Now drag-n-drop the `ExchangeRateWidget Widget` over the `Peachtree Bank WA3`
1. Disable the mocked data to test with real data
    1. Open the browser console and enter the following command on the console tab to **disable** mocked data `localStorage.setItem("enableMocks",false);`
