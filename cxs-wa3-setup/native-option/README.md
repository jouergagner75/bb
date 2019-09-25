# Native Option

## Native MySQL

* Install [MySQL 5.7.x](https://dev.mysql.com/downloads/installer/) (version 8 is not supported yet)
* MySQL Server Only option
* Root user password set to 'root'

**Add** this configuration to the my.ini [mysqld] section

        performance_schema=off
        transaction-isolation = READ-COMMITTED
        init_connect='SET collation_connection = utf8_bin'
        init_connect='SET NAMES utf8'
        character-set-server=utf8
        collation-server=utf8_bin
        skip-character-set-client-handshake
        lower_case_table_names=2

> In Windows Systems, you can find the default my.ini file at C:\ProgramData\MySQL\MySQL Server 5.7\my.ini

Update the following properties values like this:

        max_connections=500
        max_allowed_packet=512M

If you fail to perform any of the previous changes mvn bb:provision command will fail, stopping you from provisioning items to the Backbase Server.

## Native ActiveMQ

Install [Active MQ 5.14.x](http://activemq.apache.org/activemq-5145-release.html)


## Validate

* Connect to the MySQL Database with the following configuration using any MySQL client like MySQL Workbench:

	* Hostname: `localhost`
	* Port: `3306`
	* Username: `root`
	* Password: `root`

* Access the ActiveMQ Console. Credential is admin/admin:

	[http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp)