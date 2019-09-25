# Create a Multiple authentication provider

This exercise is an extension from the previous **custom-authentication-provider**. 
In the previous exercise, you created a custom provider that was authenticating against mocked data provided in the class UserDAOImpl. 
In this exercise you will have to add a second provider (LDAP) to your code. This allows Spring to request authentication from two different places

1. The previously created custom provider
2. LDAP provider (to be added in this exercise)

If the user is not available in the first provider (custom provider), Spring will try to authenticate using the second option (LDAP), defined in the SecurityConfiguration class.

This tutorial will walk you through the creation of a authentication providers.

---

## Instructions: Development environment setup

In order to setup the exercise you need **platform services** (services located inside platform folder).

### Step 1: Start your platform services

	Note: 	If they are already running you can skip this step. 
			Make sure you stopped your authentication-ldap service from blade console.
			We will use our custom authentication service which is provided for you.

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wa3-setup) to start your platform services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started. You should see only **Edge Service**, **Registry Service**,  **BB External Token Converter Service** on blade console.

### Step 2: Create a custom authentication provider

1. Clone this repository

1. Solve the TODO's inside the project

1. add this dependency in your pom file

```xml
    <!--spring security dependencies for ldap server-->
    <dependency>
        <groupId>org.springframework.ldap</groupId>
        <artifactId>spring-ldap-core</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-ldap</artifactId>
    </dependency>
    
    <!--ldap server dependencies-->
    <dependency>
        <groupId>com.unboundid</groupId>
        <artifactId>unboundid-ldapsdk</artifactId>
    </dependency>
``` 

### Step 3: Run the authentication provider 

Move into the **root** of your custom authentication provider folder and run the command :

	mvn spring-boot:run

### Step 4: Test the service

Access the authentication service and try to log in:

[http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

You should be able to login with two users

- admin:admin       -> using ldap authentication provider
- use the username that you created in TODO 5 -> using custom authentication provider 