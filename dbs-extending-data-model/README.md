# Extending Existing Capabilities

This exercise will guide you through extending  existing capabilities by adding additional data fields in contracts for DBS Contacts Capabilities.

## Prerequisites

* Setting up existing capabilities:

	[https://bitbucket.org/backbase/dbs-e01-setting-up-existing-capabilities](https://bitbucket.org/backbase/dbs-e01-setting-up-existing-capabilities)

* The following platform and capabilities must be up and running

1. Platform
1. Access Control
1. Contacts

Remember to run (*Only for capabilities you didn't start in the previous exercises, otherwise you will erase the entire database*):

	mvn clean install -Pclean-database

before running the capabilities with

	mvn blade:run

## DBS Contacts Capability

The extension of a capability is defined in a configuration file present at

`../dbs/contact-manager/contact-presentation-service/application.yml`

## Extending Data capabilities

### Contact Extensions Example

To add additional data in an api, we need to define following

   1. Dataset to be added
    * **property-name** of the field to be added in dataset
    * **Type** of the field to be added
   1. Mapping of the dataset along with the respective API to which the dataset is to be added

Observe the following code snippet from ../contact-manager/application.yml

````
backbase:
  api:
    extensions:
      classes:
        com.backbase.presentation.contact.rest.spec.v2.contacts.ContactsGetResponseBody: pokemon-data
        com.backbase.presentation.contact.rest.spec.v2.contacts.ContactsPostRequestBody: pokemon-data
        com.backbase.presentation.contact.rest.spec.v2.contacts.ContactPutRequestBody: pokemon-data
        com.backbase.pandp.party.command.rest.spec.v1.party.PartiesGetResposeBody: pokemon-data
        com.backbase.pandp.party.command.rest.spec.v1.party.PartiesPostRequestBody: pokemon-data
        com.backbase.pandp.party.command.rest.spec.v1.party.PartiesPutRequestBody: pokemon-data
        com.backbase.pandp.party.command.event.spec.v1.Party: pokemon-data
      property-sets:
        pokemon-data:
          properties:
          - property-name: favPokemon
            security:
              - confidential
            type: string
          - property-name: rank
            security:
              - confidential
            type: number
  persistence:
    enabled: false
  contact:
    audit:
      enabled: false
````

In the above code snippet, we have created a data set named : `pokemon-data`
This dataset has two fields

   * favPokemon
   * rank

There can be multiple datasets defined in one extension.

The dataset pokemon-data is then mapped to all the request and responsebody of desired apis.

### Exercise
Lets replace the pokemon-data dataset and create something more business related

1. Go to dbs/contact-manager/contact-presentation-service/application.yml
1. Replace the property-sets `pokemon-data` with `extra-info-data`
1. Remove the current properties from Pokemon and add the following
  1. socialProfileLink
  1. relationship
  1. jobTitle
1. Replace pokemon-data with extra-info-data in the `classes` part.
1. Go to dbs/contact-manager/party-pandp-service/application.yml
1. Replace the `pokemon-data` with `extra-info-data` and the `property-sets` to match what was created in the `contact-presentation-service`

### Testing the newly added fields

Execute the calls and check if the information is being properly saved and returned

**Note that you are not adding any permission to Peter because these permissions were added in the previous exercise, extending behavior of contacts**