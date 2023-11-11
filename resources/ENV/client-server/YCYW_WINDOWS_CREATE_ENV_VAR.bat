@echo off
	chcp 65001
	color 0A
	:: Window's height 
	mode con lines=35
	:: YCYW
	title YCYW - Environment variables
	echo.
	echo ############
	echo ### YCYW ###
	echo ############
	echo.
	set /p "jwtSecret=Enter YCYW JWT secret : "
	setx YCYW_YL_TOKEN_SECRET %jwtSecret%
	echo.
	set /p "jwtIssuer=Enter YCYW JWT issuer : "
	setx YCYW_YL_TOKEN_ISSUER %jwtIssuer%
	echo.
	set /p "postgreUser=Enter YCYW PostgreSQL username for yourcaryourway schema : "
	setx YCYW_YL_POSTGRES_USERNAME %postgreUser%
	echo.
	set /p "postgrePassword=Enter YCYW PostgreSQL password for yourcaryourway schema : "
	setx YCYW_YL_POSTGRES_PASSWORD %postgrePassword%
	echo.
exit