# Creating the service implementation

After creating the specification, it is time to implement the service.

Search for the TODOs inside the project and complete the missing pieces of code.

### Run the service

After finishing all TODOs run the following command inside the ***atm-location-service*** root:

	mvn spring-boot:run

### Test the service

First, let's check if our service instance appears available in the Registry:

[http://localhost:8080/registry](http://localhost:8080/registry)

Log in through the authentication service

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

Hit the service

[http://localhost:8080/gateway/api/atm-location-service/v1/locations](http://localhost:8080/gateway/api/atm-location-service/v1/locations)

