# Creating the service implementation

After creating the specification, it is time to implement the service.

### Step 1: Include specification dependency

Follow the TODO in ***atm-location-service/pom.xml*** file.

### Step 2: Make the service accessible

Use correct property to make the service available through the Edge Service in application.yml

### Step 3: Include annotations

You should use annotations for auto scanning the package, internal JWT consumer and to register in the Registry.

Follow the TODOs inside ***com.backbase.Application*** class.

### Step 4: Call external service

To get the data from Open Bank API you should complete RestTemplate class.

Follow the TODOs inside ***com.backbase.Application*** and ***com.backbase.atms.AtmLocationsRestController*** classes.

### Step 5: Run the service

Run the following command inside the ***atm-location-service*** root:

	mvn spring-boot:run

### Step 6: Test the service

First, let's check if our service instance appears available in the Registry:

[http://localhost:8080/registry](http://localhost:8080/registry)

You can also check that service is public available via Gateway:

Log in through the authentication service

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

Now check that your service has the attribute `public: true`

[http://localhost:8080/gateway/api_gw/routes](http://localhost:8080/gateway/api_gw/routes)

Hit the service

[http://localhost:8080/gateway/api/atm-location-service/v1/locations](http://localhost:8080/gateway/api/atm-location-service/v1/locations)

### Step 7: Integration with a real widget

1. Go to the `../cxs-be-direct-integration/extras`
1. Open the folder package
1. Go to the Enterprise catalog in Experience manager and drag and drop (or use the import button) each zip file into it.
    * 00000_config-bb-providers-ng.zip
    * 00001_data-bb-locations-http-ng.zip
    * 00002_ext-training-atm-details-ng.zip
    * 00003_ext-training-atm-list-ng.zip
    * 00004_mock.data-bb-locations-http-ng.zip
    * 00005_model-training-atm-list-ng.zip
    * 00006_widget-training-atm-details-ng.zip
    * 00007_widget-training-atm-list-ng.zip
1. Go to your Experience Catalog and add the widgets `ATM List` and `ATM Details` to it
1. Go to your Master Page and on the settings change `Web-basic` to `Backbase Demo Page`
1. Add the widgets to your page and preview the page.
1. Add `?disable-mocks` to your URL to get the data from the `atm-location-service`

