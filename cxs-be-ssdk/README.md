# Create microservices using Backbase Service SDK

This tutorial will walk you through the creation of different kind of microservices using Service SDK.


What you are trying to achieve in this exercise is the following

1. Create a specification project, then create your own RAML specification file, and finally generate the Java sources from it using our maven plugin
1. Generate the microservice with Backbase Service SDK (Direct Integration Service) that will provide the functionality for the previously created specification. The functionality will be
	* Make a request to an external service from your service
	* Create the necessary classes (domain, services and converters) to map the result from that request to what was definied in the specification
	* Test it executing a request to your service from the browser, it will look like: Request from the browser -> your service -> external service -> your service gets the response and map to specification -> return the response to the browser

---

## Instructions: Development environment setup

In order to setup the exercise you need **platform services** (services located inside platform folder).

### Step 1: Start your platform services

    Note:   If they are already running you can skip this step.

1. Follow [this guide](https://bitbucket.org/backbase/cxs-wc2-setup) to start your platform services.

2. Access [Blade console](http://localhost:8080) and check if services were successfully started. You should see only **registry** and **gateway** in blade console.

### Step 2: Create a specification project

1. Go to the folder where your projects are and use the archetype below to generate your specification project.

		mvn archetype:generate \
		 -DarchetypeArtifactId=raml-specifications-archetype \
		 -DarchetypeGroupId=com.backbase.archetype \
		 -DarchetypeVersion=7.0.1 \
		 -DserviceName=my-custom-specification \
		 -DservicePackageName=spec

1. To facilitate the naming alignment, assign the following values to your project configuration:

	* groupId = `com.backbase.training`
	* artifactId = `my-custom-specification`

	For everything else, accept the default values
	
1. Investigate the RAML file generated for you inside the project.

1. Change the RAML content with the below information to make it simpler.

		#%RAML 1.0
		---
		#===============================================================
		#  References:
		#    - RAML Specification - https://github.com/raml-org/raml-spec/blob/master/versions/raml-10/raml-10.md
		#===============================================================
		title: My First Specification
		uses:
		  traits: lib/traits/traits.raml
		version: v1
		baseUri: "/{version}"
		mediaType:  application/json
		protocols: [ HTTP, HTTPS ]
		#===============================================================
		# API resource definitions
		#===============================================================
		/helloworld:
		  displayName: User
		  get:
		    queryParameters:
		     id:
		      displayName: id
		      type: string
		     name:
		      displayName: name
		      type: string
		    responses:
		      200:
		        description: Example response
		        body:
		          application/json:
		            type: | # structural definition of a response (schema or type)
		              {
		                "title": "Hello world Response",
		                "type": "object",
		                "properties": {
		                  "id": {
		                    "type": "string"
		                  },
		                  "name": {
		                    "type": "string"
		                   },
		                   "message": {
		                    "type": "string"
		                   }
		                }
		              }

1. Build your project to generate Java objects.

	`mvn clean install`
	
1. Investigate the generated classes under `target` folder.

### Step 3: Create an implementation microservice

1. Go to the folder where your projects are and use the archetype below to generate your implementation microservice.

		mvn archetype:generate\
		 -DarchetypeArtifactId=direct-integration-service-archetype\
		 -DarchetypeGroupId=com.backbase.archetype\
		 -DarchetypeVersion=7.0.1\
		 -DserviceName=my-custom-service
		 
1. To facilitate the naming alignment, assign the following values to your project configuration:

	* groupId = `com.backbase.training`
	* artifactId = `my-custom-service`

	For everything else, accept the default values
	
1. Add specification dependency to your microservice.

		<dependency>
			<groupId>com.backbase.training</groupId>
			<artifactId>my-custom-specification</artifactId>
			<version>1.0.0-SNAPSHOT</version>
		</dependency>
		
1. Your microservice will use internal token, so add the below property to your environment variables. 

	* name: `SIG_SECRET_KEY`
	* value: `JWTSecretKeyDontUseInProduction!`

	You can either use the maven plugins to set this value.

	    <plugin>
	        <groupId>org.codehaus.mojo</groupId>
	        <artifactId>properties-maven-plugin</artifactId>
	        <version>1.0.0</version>
	        <executions>
	            <execution>
	                <goals>
	                    <goal>set-system-properties</goal>
	                </goals>
	                <configuration>
	                    <properties>
	                        <property>
	                            <name>SIG_SECRET_KEY</name>
	                            <value>JWTSecretKeyDontUseInProduction!</value>
	                        </property>
	                    </properties>
	                </configuration>
	            </execution>
	        </executions>
	    </plugin>
	    
1. Go to your projects `application.yml` file and change the registry port to `8080`.

1. Open your `ExampleController` class. Instead of implementing DummyApi, implement `UserApi` interface that you created in specification project. 

1. Now you can use `http://rest-service.guides.spring.io/greeting` endpoint as a 3rd party to make a call. 

1. Get the data and use `content` field as a `message` field in `User` class.

		HINT: Generate the needed Java beans.

1. Transform the data that you get from 3rd party to `User` object. User object will have `id`, `name` and `message` fields. Then expose it for frontend. You can use [mapstruct.org](http://mapstruct.org/) for transforming your objects.

### Step 4: Run your microservice

Move into your custom microservice folder and run the command:

	mvn spring-boot:run	

### Step 5: Test your service

1. First, let's check if our service instance appears available in the Registry:

	[http://localhost:8080/registry](http://localhost:8080/registry)

1. You can also check that service is public available via Gateway:

	Log in through the authentication service: [http://localhost:8080/gateway/api/auth/login](http://localhost:8080/gateway/api/auth/login)


	Check if your custom service is registered: [http://localhost:8080/gateway/api_gw/routes](http://localhost:8080/gateway/api_gw/routes)

1. Hit the service

	[http://localhost:8080/gateway/api/my-custom-service/v1/helloworld/1234/erkin](http://localhost:8080/gateway/api/my-custom-service/v1/helloworld/1234/erkin)
	
You should see the body of the response like:

	{
		"id": "1234",
		"name": "erkin",
		"message": "Hello, World!"
	}