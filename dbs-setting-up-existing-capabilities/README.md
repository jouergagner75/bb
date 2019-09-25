# Setting up existing DBS Capabilities

This exercise will guide you through the setup of:

* Platform
* Access Control
* Product Summary

**Don't forget to add the original authentication-ldap back to the platform by uncommenting the modules and dependencies from the platform/pom.xml**

# Setting up the LDAP users

For this exercise we are going to use a specific set of users that are not provided inside `platform/authentication-ldap/config/backbase/users.ldif`. Replace the entire content of the `users.ldif` by the ones provided [here](files/users.ldif)


## Prerequisites

* Backbase 6 with WA3 setup:

	[https://codebase.backbase.com/projects/TRCO/repos/cxs-wa3-setup/browse](https://codebase.backbase.com/projects/TRCO/repos/cxs-wa3-setup/browse)

## Validate

* Access the ActiveMQ Console. Credential is admin/admin:

	[http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp)

* Connect to the MySQL Database:

	* Hostname: localhost
	* Port: 3306
	* Username: root
	* Password: root

## Start Backbase Platform

Start Infrastructure and Platfrom Services

	cd platform
	mvn blade:run

## Validate

* Access Eureka Server:

	[http://localhost:8080/registry/](http://localhost:8080/registry/)

## Run the capabilities

We will need the following capabilities running for the next exercise:

1. Access Control
1. Product Summary

Increase the memory for access-control blade go to

`..dbs/access-control/.mvn/jvm.config` replace the **MaxMetaspaceSize** and **Xmx** with the following values

`-XX:MaxMetaspaceSize=1400000K -Xmx1500000K`

Also increase the memory for the product-summary blade:

`..dbs/product-summary/.mvn/jvm.config` replace the **MaxMetaspaceSize** and **Xmx** with the following values

`-XX:MaxMetaspaceSize=1G -Xmx1G`

To run them follow the instructions below:

## DBS Access Control

	cd dbs/access-control
	mvn clean install -Pclean-database
	mvn blade:run
	
## DBS Product Summary

	cd dbs/product-summary
	mvn clean install -Pclean-database
	mvn blade:run
	

## Validate

Check access-control blade: [http://localhost:8086](http://localhost:8086)

Check product-summary blade: [http://localhost:8082](http://localhost:8082)
