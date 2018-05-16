# Creating the service implementation

After creating the specification, it is time to implement the service.

## Instructions

To call the `/atms` endpoint, the current suggested implementation will make use of a stub created from the Swagger specification located in `spec/swagger` folder. 

### Step 1: Generating helper classes

Run the command inside the root of your **"atm-location-service"** project.

	mvn clean generate-sources

The project is already structured with a few missing parts. 

### Step 2: Include specification dependency

Follow the TODOs in ***atm-location-service/pom.xml*** file.

### Step 3: Make the service accessible

Use correct property to make the service available through the Edge Service in application.yml

### Step 4: Include annotations

You should use annotations for auto scanning the package, internal JWT consumer and to register in the Registry. 

Follow the TODOs inside ***com.backbase.Application*** class.

### Step 5: Call external service

To get the data from Open Bank API you should complete RestTemplate class.

Follow the TODOs inside ***com.backbase.Application*** and ***com.backbase.atms.AtmLocationsRestController*** classes.

### Step 6: (Optional) Call external service using Apache Camel

You can **optionally** follow the TODOs inside ***com.backbase.atms.AtmLocationsRoute*** and ***com.backbase.atms.AtmLocationsController*** to complete the Camel route.

### Step 7: Run the service

Run the following command inside the ***atm-location-service*** root:

	mvn spring-boot:run

### Step 8: Test the service

First, let's check if our service instance appears available in the Registry:

[http://localhost:8080/registry](http://localhost:8080/registry)

You can also check that service is public available via Gateway:

Log in through the authentication service

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

Now check that your service has the attribute `public: true`

[http://localhost:8080/gateway/api_gw/routes](http://localhost:8080/gateway/api_gw/routes)

Hit the service

[http://localhost:8080/gateway/api/atm-location-service/v1/locations](http://localhost:8080/gateway/api/atm-location-service/v1/locations)

