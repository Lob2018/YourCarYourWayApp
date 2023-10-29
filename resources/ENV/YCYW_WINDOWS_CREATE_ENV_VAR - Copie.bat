@echo off
	chcp 65001
	color 0A
	:: Window's height 
	mode con lines=35
	:: SERVICE COMPTE
	title SERVICE COMPTE - GLOBAL
	echo.
	echo ######################
	echo ### SERVICE COMPTE ###
	echo ######################
	echo.
	set /p "comptePortCPT=Enter Tomcat port for compte-service : "
	setx YCYW_YL_SERVICE_COMPTE_SERVER_PORT %comptePortCPT%
	echo.
	set /p "jwtSecret=Enter YCYW JWT secret : "
	setx YCYW_YL_SERVICE_COMPTE_TOKEN_SECRET %jwtSecret%
	echo.
	set /p "jwtIssuer=Enter MDD JWT issuer : "
	setx YCYW_YL_SERVICE_COMPTE_TOKEN_ISSUER %jwtIssuer%
	echo.
	title SERVICE COMPTE - DB
	set /p "postgreDBNameCPT=Enter YCYW PostgreSQL database name for compte-service : "
	setx YCYW_YL_SERVICE_COMPTE_POSTGRES_DBNAME %postgreDBNameCPT%
	echo.
	set /p "postgrePortCPT=Enter YCYW PostgreSQL port for compte-service : "
	setx YCYW_YL_SERVICE_COMPTE_POSTGRES_PORT %postgrePortCPT%
	echo.
	set /p "postgreUserCPT=Enter YCYW PostgreSQL username for compte-service : "
	setx YCYW_YL_SERVICE_COMPTE_POSTGRES_USERNAME %postgreUserCPT%
	echo.
	set /p "postgrePasswordCPT=Enter YCYW PostgreSQL password for compte-service : "
	setx YCYW_YL_SERVICE_COMPTE_POSTGRES_PASSWORD %postgrePasswordCPT%
	echo.
	:: SERVICE TCHAT
	title SERVICE TCHAT - GLOBAL
	cls
	echo.
	echo #####################
	echo ### SERVICE TCHAT ###
	echo #####################
	echo.
	set /p "comptePort=Enter Tomcat port for tchat-service : "
	setx YCYW_YL_SERVICE_TCHAT_SERVER_PORT %comptePort%
	echo.	
	title SERVICE TCHAT - DB
	set /p "postgreDBNameTCHAT=Enter YCYW PostgreSQL database name for tchat-service : "
	setx YCYW_YL_SERVICE_TCHAT_POSTGRES_DBNAME %postgreDBNameTCHAT%
	echo.
	set /p "postgrePortTCHAT=Enter YCYW PostgreSQL port for tchat-service : "
	setx YCYW_YL_SERVICE_TCHAT_POSTGRES_PORT %postgrePortTCHAT%
	echo.
	set /p "postgreUserTCHAT=Enter YCYW PostgreSQL username for tchat-service : "
	setx YCYW_YL_SERVICE_TCHAT_POSTGRES_USERNAME %postgreUserTCHAT%
	echo.
	set /p "postgrePasswordTCHAT=Enter YCYW PostgreSQL password for tchat-service : "
	setx YCYW_YL_SERVICE_TCHAT_POSTGRES_PASSWORD %postgrePasswordTCHAT%
	echo.
exit