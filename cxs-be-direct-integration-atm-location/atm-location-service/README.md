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

### Integrate the service with real widgets

1. Go to the `../extras` folder in your terminal
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
    1. AtmWidget Widget
1. Go back to your home page and do the following steps
    1. First drag-n-drop the `Peachtree Bank WA3` App into the page
    1. Now drag-n-drop the `AtmWidget Widget` over the `Peachtree Bank WA3`
1. Disable the mocked data to test with real data
    1. Open the browser console and enter the following command on the console tab to **disable** mocked data `localStorage.setItem("enableMocks",false);`
