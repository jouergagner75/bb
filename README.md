# How to implement a direct integration service

A Direct Integration Service is a micro-service that is built with the Backbase Service SDK and runs within the Backbase 6 infrastructure (Edge Service and Registry Service).

For this exercise, you will create a Direct Integration Service exposing the **"/locations"** REST endpoint, defined by a provided RAML specification. This endpoint will be consumed by the Locations Widget.

Internally, this service will call the Open Bank API's **"/atms"** REST service, defined by a Swagger specification.

You can access the Open Bank **/atms** endpoint through this [URL](https://api.hsbc.com/open-banking/v2.1/atms)

---

## Instructions: Development environment setup
In order to setup the exercise you need **Edge Service** and **Registry Service**, so you will only require the platform services.

### Step 1: Start your platform services

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wc2-setup) to start your platform services.

1. Access [Blade console](http://localhost:8080) and check if services were successfully started.

### Step 2: Cloning projects

This repository contains two modules partially built. Inside each project you will find a README.md file with the instructions to fully build it and complete the exercise.

1. Clone this repository into your computer

1. Follow the steps in README.md file located at **"atm-location-specification"** and then move to the README.md located at **"atm-location-service"**

	*  [atm-location-specification](atm-location-specification/README.md)
	
	*  atm-location-service