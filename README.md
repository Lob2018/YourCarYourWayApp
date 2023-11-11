# YCYW (Your Car your Way App chat PoC)

</br>

This project was generated with:

> [OpenJDK](https://openjdk.org/projects/jdk/17/) version 17.0.5

> [Spring Boot](https://spring.io/projects/spring-boot) version 3.1.5

> [Spring Security](https://spring.io/projects/spring-security)

> [Node](https://nodejs.org/docs/v18.18.2/api/) version 18.18.2

> [NPM](https://docs.npmjs.com/cli/v9/commands/npm?v=true) version 9.8.1

> [Angular](https://github.com/angular/angular/tree/16.2.0) version 16.2.0

</br>

# Back-End

</br>

Git clone (Back-End is in the ./back folder):

> git clone https://github.com/Lob2018/YourCarYourWayApp

</br>

Set the user's environment variables (batch file with command prompt)

> Inside `resources/ENV/client-server`, double-click on `YCYW_WINDOWS_CREATE_ENV_VAR.bat`, to set the variables`*` and note their values`*`

[Those environment variables are needed to use this APP](#user-environment-variables-details)

(double-click on `YCYW_WINDOWS_DROP_ENV_VAR.bat` if you want to remove them after)

</br>

PostgreSQL version 16 :

> Port: 5432 (default)

> Create the username and the password (`*`from noted values)

> Create a new schema named: yourcaryourway

> Give rights for this username on the yourcaryourway schema

> Execute the queries from the script `./resources/DB/client-server/yourcaryourway.sql` for the yourcaryourway schema

</br>

Start the API inside /back :

> Run : `mvn clean spring-boot:run`

</br>

The ports used with localhost

> **YCYW Spring boot application port : 8081**

> **YCYW Angular port: 4200**

</br>

Extra resources

> UML of the app `./resources/UML`

</br>

# Front-End

</br>

Inside ./front :

> Install : npm install

> Start : npm run start

</br>

Login data for users :

* John as a user :
  * role : USER
  * mail : <user@example.com>  
  * password : password

* Jane as an employee :
  * role : EMPLOYEE
  * mail : <employee@example.com>
  * password : password

1 Tchat is running between them with 1 question and 1 answer (for PostgreSQL testing)

</br>

## User environment variables details

</br>

> Variable YCYW JWT secret : `YCYW_YL_TOKEN_SECRET`

> Variable YCYW JWT issuer: `YCYW_YL_TOKEN_ISSUER`

> Variable YCYW PostgreSQL username for yourcaryourway : `YCYW_YL_POSTGRES_USERNAME`

> Variable YCYW PostgreSQL password for yourcaryourway : `YCYW_YL_POSTGRES_PASSWORD`

</br>