# Create a custom in-memory authentication service

Authentication service is used to provide authentication and authorization for downstream services.

This tutorial will walk you through the creation of a custom authentication service with the Backbase Service SDK / Building Blocks.

---

## Instructions: Development environment setup

In order to setup the exercise you need **platform services** (services located inside platform folder).

### Step 1: Disable default authentication-ldap

In this exercise we will use our own custom authentication service. Before you start the platform you have to disable the default authentication service. Inside **platform folder** change the **pom.xml** by commenting the following lines:

```
<module>authentication-ldap</module>
```

```
<dependency>
    <groupId>com.backbase.infra</groupId>
    <artifactId>authentication-ldap</artifactId>
    <type>war</type>
    <version>${auth-services-version}</version>
</dependency>

```

```
<webApp>
    <module>authentication-ldap</module>
    <springBoot1App>true</springBoot1App>
</webApp>
```

### Step 2: Start your platform services

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wa3-setup) to start your platform services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started. You should see only **registry**, **gateway**, and **bb-authentication-token-converter-service** in blade console.

### Step 3: Create your custom in-memory authentication service

Go to the folder where your projects are and run the command:

	mvn archetype:generate \
        -DarchetypeArtifactId=auth-service-archetype \
        -DarchetypeGroupId=com.backbase.archetype \
        -DarchetypeVersion=2.0.1 \
        -DgroupId=com.backbase.training.service.auth \
        -DartifactId=auth-service \
        -Dversion=1.0-SNAPSHOT \
        -Dpackage=com.backbase.service.auth \
        -B

### Step 4: Setup the application

In the **application.yml** file located **in the root of your project** and setup the registry port (check were your registry is running locally, port 8080 by default)

	serviceUrl:
      defaultZone: http://localhost:8080/registry/eureka/

PS: By default the external token is only signed because of the configuration showed below on **application.yml**. If you want to connect to experience manager change it to **signedEncrypted**
    
    sso:
      jwt:
        external:
          type: signed #Change to signedEncrypted if you want to use the experience manager

    
### Step 5: Add custom users 

Add more users for testing purposes in the `SecurityConfiguration.java` class. 

### Step 6: Build the project

Move into your custom authentication service folder and run the command :

	mvn clean install

### Step 7: Run your custom authentication service

Inside the same folder run :

	mvn spring-boot:run

### Step 8: Test the service

Access the authentication service and try to log in with users you created:

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)
