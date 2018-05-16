## Creating the JSON schemas specification

Open and analyze the file *locations-get-response.json* located at: *main/resources/examples* .

Based on the *locations-get-response.json*, create the following JSON schema inside *main/resources/schemas*:

* address.json

Pay extra attention to the properties created inside these files: they should match the properties described by the JSON in the file *locations-get-response.json* .

Once you've finished, run the following command inside the *atm-location-specification* root:

``` mvn clean install ```

Explore the target folder created, can you tell what is the REST endpoint generated?

Proceed to the README.md file located at [atm-location-service/README.md](../atm-location-service/README.md)