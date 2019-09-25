# Override login controller

The authentication service comes with a set of default endpoints expected to be implemented as a part of minimum service contract:

- /login
- /logout
- /refresh
- /status

The goal of this exercise is to override the `/login` endpoint to customise the response. You are requested to check the code and append the **ExternalJwtToken**. Notice that you have to create an ExternalJwtToken as a cookie and add it to the HTTP response.

---

## Instructions: Development environment setup


In order to setup the exercise you need **platform services** (services located inside platform folder).

### Step 0: Stop the previous exercise 

Since you are building a new microservice that will be the same authentication service please stop the one created previously.

### Step 1: Start your platform services

	Note: 	If they are already running you can skip this step. 
			Make sure you stopped your authentication-ldap service from blade console.
			We will use our custom authentication service which is provided for you.


1. Follow [this guide](https://bitbucket.org/backbase/cxs-wa3-setup) to start your platform services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started. You should see only **Edge Service**, **Registry Service**,  **BB External Token Converter Service** on blade console.


### Step 2: Solve the TODO's

1. Clone this repository

1. Solve the TODO's in this project

### Step 3: Build the project

Move into the **root** of your project and run the command :
	
	mvn clean install

### Step 4: Run the service

Inside the same folder run the command :

	mvn spring-boot:run

### Step 5: Test the service

1. Go to the authentication service and try to log in. You should see different login page:

    [http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)

1. Check if the JWT is returned as cookie through the inspector (such as Developer Tools from Google Chrome)

