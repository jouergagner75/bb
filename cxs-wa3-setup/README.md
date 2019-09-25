# CXS 6.1.1, Platform and DBS 2.16.0 development environment setup

This exercise will guide you on setting up Backbase CXS 6.1.1, Platform and DBS 2.16.0 development environment in your local machine.

### Important Note: Running CXS for the second time

Going through this installation guide is not required to start Backbase CXS. If you already installed the software, and you want to restart Backbase CXS, this is what you need to do:

1. Start MySQL and ActiveMQ services

		Using the terminal go to the `platform` folder of your project and run `docker-compose up`


1. Run the platform services

		Using the terminal, open another session inside the `platform` folder and run `mvn blade:run`


1. Run the Customer Experience Services

		Using the terminal go to the `cx6-targeting` folder of your project and run `mvn blade:run`

## Backbase CXS Installation Guide

### Step 1: Prerequisites

* Required

	1. [Java JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Java 9 and 10 are not supported)
	2. [Maven 3.5.x](http://maven.apache.org/install.html) (Maven 3.6.x is not supported)
	3. [Docker](https://docs.docker.com/engine/installation/) (Please use Docker Community Edition, Docker Toolbox is not compatible) or [Native Installation of MySQL and ActiveMQ](native-option)

* Optional

	1. [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

		> Or any other MySQL client tool, if you want to check the database content.

### Step 2: Setting environment variables

1. Make sure that your environment variables are set as follows:

	`JAVA_HOME = <<<jdk-home-directory>>>`

	`M2_HOME = <<<maven-home-directory>>>`

	`M2 = <<<maven-bin-directory>>>`

	PATH should contain `<<<jdk-bin-directory>>>` and `<<<maven-bin-directory>>>`

2. Confirm your Java and Maven installations by making sure both JDK and Maven can be executed from the command line. You can test it by executing the following commands:

		javac -version
		mvn --version

	(make sure Maven uses the right version of Java; if not, check your JAVA_HOME environment variable)

### Step 3: Maven configuration for Backbase repository

1. Configure Maven by editing the settings.xml file. It is located in:
	- Microsoft Windows: `C:\Users\user_name\.m2`
	- Unix and OS X: `~/.m2`
	- The file should contain the following lines and replace the `user_name` and `password`:


			<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
					xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
					xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
				<profiles>
					<profile>
						<id>backbase</id>
						<activation>
							<activeByDefault>true</activeByDefault>
						</activation>
						<repositories>
							<repository>
								<id>Backbase Artifact Repository</id>
								<url>https://repo.backbase.com/repo/</url>
							</repository>
						</repositories>
						<pluginRepositories>
							<pluginRepository>
								<id>Backbase Artifact Repository</id>
								<url>https://repo.backbase.com/repo/</url>
							</pluginRepository>
						</pluginRepositories>
					</profile>
				</profiles>
				<servers>
					<server>
						<id>Backbase Artifact Repository</id>
						<username>user_name</username>
						<password>password</password>
					</server>
				</servers>
			</settings>

### Step 4: Generate a project

1. Go to [http://start-training.backbase.com](http://start-training.backbase.com)
2. Select "Start project" and then choose "Predefined Template"
3. Select the "Retail Banking" template and press "Next"
4. Fill the form according to the following details:
    - Project title: Training
    - Maven Group ID: com.backbase.training
    - Global Prefix: training
    - Java Package name: com.backbase.training
    - Description: Backbase Training project
5. Click on the button **Download Package**.  A .zip file will be downloaded to your "Downloads" folder.
6. Move this .zip file to an easily accessible location and extract its contents.  Recommended locations:
		- Mac: <your-user-folder>/backbase/
		- Windows: C:/bb-training/
> If these folders don't exist, please create them.
7. Rename the extracted folder to "bb-cxs"

### Step 5: Run MySQL and ActiveMQ using Docker

**Note: Skip Step 5 if you are running MySQL and ActiveMQ natively.**

CXS requires MySQL and ActiveMQ to be running as services. For your convenience, this project also comes with a docker-compose that starts these services and binds them to localhost.

If your environment does not support Docker for Mac/Windows, then you must use the [native MySQL and ActiveMQ instructions](native-option). 

1. Make sure the following ports are not being used
	* Ports which will be used by ActiveMQ:

		`61616`, `8161`, `5672`, `61613`, `1883`, and `61614`

	* Port which will be used by MySQL:

		`3306`

2. Install Docker

	* [Docker for Mac](https://www.docker.com/docker-mac)
	* [Docker for Windows](https://www.docker.com/docker-windows)

3. Run Docker Compose for MySQL and ActiveMQ. Start a terminal session to start ActiveMQ and MySQL with Docker inside the folder `platform` of the project (/bb-cxs/platform):

		docker-compose up

### Step 6: Run the Platform Services and CXS

The Backbase Platform services are required to run DBS and CXS on your local machine and is composed of the following services:

- Registry Service
- Edge Service
- Authentication Service

Make sure port `9080` and `8080` is not being used by any other process.

1. In another terminal session, go to the `platform` folder and run

		mvn blade:run

2. In another terminal session, go to `cx6-targeting` folder. To create the needed databases and tables execute :

		mvn clean install -Pclean-database

3. To start the services:

		mvn blade:run

### Step 7: Provision statics and import the experiences

1. To import the collection, navigate to `statics` folder and run the command:

		mvn bb:provision

2. To import all experience packages configured in the pom files execute in `statics`:

		mvn bb:import-experiences


> To import an experience one by one, navigate to the subdirectory and run `mvn bb:import-experiences` to only import experience packaged configured in the *'bb-maven-plugin'*

### Step 8: Validate

1. Navigate to Experience Manager:

	* [http://localhost:8080/gateway/cxp-manager](http://localhost:8080/gateway/cxp-manager)

	* Use the following credentials to log in: ( User: admin / Password: admin)


Congratulations, you have successfully installed Backbase CXS.
