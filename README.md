# YCYW (Your Car your Way App chat PoC)

</br>

This project was generated with:

> [OpenJDK](https://openjdk.org/projects/jdk/17/) version 17.0.5

> [Spring Boot](https://spring.io/projects/spring-boot) version 3.1.5

> [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

> [Spring Cloud Eureka Discovery](https://spring.io/projects/spring-cloud-netflix)

> [Spring Cloud Config Server](https://spring.io/projects/spring-cloud-config)

> [Spring Security](https://spring.io/projects/spring-security)

> [Node](https://nodejs.org/docs/v18.16.0/api/) version 18.16.0

> [NPM](https://docs.npmjs.com/cli/v9/commands/npm?v=true) version 9.5.1

> [Angular](https://github.com/angular/angular/tree/14.3.0) version 14.3.0

</br>

# Back-End

</br>

Git clone (Back-End is in the ./back folder):

> git clone https://github.com/Lob2018/YourCarYourWayApp

</br>

Set the user's environment variables (batch file with command prompt)

> Inside `resources/ENV`, double-click on `YCYW_WINDOWS_CREATE_ENV_VAR.bat`, to set the variables`*` and note their values`*`

[Those environment variables are needed to use this APP](#user-environment-variables-details)

(double-click on `YCYW_WINDOWS_DROP_ENV_VAR.bat` if you want to remove them after)

</br>

PostgreSQL version 16 :

> Port: from environment variables (5432 by default)

> Create the username and the password (`*`from noted values)

> Create a new schema named: yourcaryourwayCompte

> Create a new schema named: yourcaryourwayTchat

> Give rights for this username on the yourcaryourwayCompte schema

> Give rights for this username on the yourcaryourwayTchat schema

> Execute the queries from the script `./resources/DB/yourcaryourwayCompte.sql` for the yourcaryourwayCompte schema

> Execute the queries from the script `./resources/DB/yourcaryourwayTchat.sql` for the yourcaryourwayTchat schema

</br>

Start the API :

* Spring Cloud Eureka Discovery
  * Inside `back/discovery-service` 
  * run `mvn clean spring-boot:run`

* Spring Spring Cloud Config
  * Inside `back/config-service` 
  * run `mvn clean spring-boot:run`

* Spring Cloud Gateway
  * Inside `back/gateway-service` 
  * run `mvn clean spring-boot:run`

* Compte service
  * Inside `back/compte-service` 
  * run `mvn clean spring-boot:run`

* Tchat service
  * Inside `back/tchat-service` 
  * run `mvn clean spring-boot:run`

The ports used

> Spring Cloud Eureka Discovery : 8761

> Spring Cloud Config : 8888

> **Spring Cloud Gateway : 8081**

> **Angular port: 4200**

</br>

Extra resources

> UML of the app `./resources/UML`

><span style="color:red;">Be careful, the following batches kill all the PIDs of the processes listening on the application ports (8761,8888, etc.)</span>

* Start all services `./resources/CMD DANGER/START.bat`
* Kill all associated PIDs `./resources/CMD DANGER/STOP.bat`

</br>

# Front-End

</br>

Inside ./front :

> Install : npm install

> Start : npm run start

</br>

## User environment variables details

</br>

SERVICE COMPTE :

> Variable Tomcat port for compte-service : `YCYW_YL_SERVICE_COMPTE_SERVER_PORT`

> Variable YCYW JWT secret : `YCYW_YL_SERVICE_COMPTE_TOKEN_SECRET`

> Variable YCYW JWT issuer: `YCYW_YL_SERVICE_COMPTE_TOKEN_ISSUER`

> Variable  YCYW PostgreSQL database name for compte-service : `YCYW_YL_SERVICE_COMPTE_POSTGRES_DBNAME`

> Variable YCYW PostgreSQL port for compte-service : `YCYW_YL_SERVICE_COMPTE_POSTGRES_PORT`

> Variable YCYW PostgreSQL username for compte-service : `YCYW_YL_SERVICE_COMPTE_POSTGRES_USERNAME`

> Variable YCYW PostgreSQL password for compte-service : `YCYW_YL_SERVICE_COMPTE_POSTGRES_PASSWORD`

SERVICE TCHAT :

> Variable Tomcat port for tchat-service : `YCYW_YL_SERVICE_TCHAT_SERVER_PORT`

> Variable YCYW PostgreSQL database name for tchat-service : `YCYW_YL_SERVICE_TCHAT_POSTGRES_DBNAME`

> Variable YCYW PostgreSQL port for tchat-service : `YCYW_YL_SERVICE_TCHAT_POSTGRES_PORT`

> Variable YCYW PostgreSQL username for tchat-service : `YCYW_YL_SERVICE_TCHAT_POSTGRES_USERNAME`

> Variable YCYW PostgreSQL password for tchat-service :  `YCYW_YL_SERVICE_TCHAT_POSTGRES_PASSWORD`

</br>
