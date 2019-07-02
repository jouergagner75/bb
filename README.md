# How to implement a direct integration service

You already know what is a direct integration service and when it should be used. Now let's warm-up a little.
Here you have a project partially done. In this project you will find

1. atm-location.specification 
1. atm-location-service

These services will connect to a server at [HSBC](https://api.hsbc.com/open-banking/v2.1/atms) to retrieve the HSBC ATM locations.

So far you saw that Backbase follows the contract first approach through RAML. That is why we have a specification called `atm-location-specification`. This is the contract between our `atm-location-service` and the widgets.

The purpose of this service is to get the data from HSBC, fulfill the contract by mapping the data to the specification project and return the data to the widgets.

Since this is a warm-up exercise both services are partially done. We removed essential parts of it and replaced with TODOs.

Your job is to follow the TODOs and replace the missing parts with the right code.

---

## Instructions: Development environment setup

In order to setup the exercise you need **Edge Service, Registry Service, Authentication Service and Token Converter**, so you will require the platform services.

### Step 1: Start your platform

	Note: 	If they are already running you can skip this step. 

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wc3-setup) to start your platform and CXS services.

1. Access [Blade console](http://localhost:8080) and check if platform services were successfully started.

### Step 2: Cloning projects

This repository contains two modules partially built. Inside each project you will find a README.md file with the instructions to fully build it and complete the exercise.

1. Clone this repository into your computer

1. Follow the steps in README.md file located at **"atm-location-specification"** and then move to the README.md located at **"atm-location-service"**

	*  [atm-location-specification](atm-location-specification/README.md)
	
	*  atm-location-service