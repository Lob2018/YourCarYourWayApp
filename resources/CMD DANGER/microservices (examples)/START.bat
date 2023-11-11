@echo off
	chcp 65001
	color 0A
	:: START YOUR CAR YOUR WAY
	title START YOUR CAR YOUR WAY
	echo.
	echo ############################################################################
	echo # ATTENTION : ce script tue les PIDs associés aux ports de l'application ! #
	echo ############################################################################
	pause
	echo.
	echo Fermeture de Spring Cloud Eureka Discovery...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8761"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage de Spring Cloud Eureka Discovery...
	cd ../../back/discovery-service
	start cmd /k "title Démarrage de Spring Cloud Eureka Discovery... && mvn clean spring-boot:run"	
	echo.

	echo Fermeture de Spring Cloud Config...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8888"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage de Spring Cloud Config...
	cd ../../back/config-service
	start cmd /k "title Démarrage de Spring Cloud Config... && mvn clean spring-boot:run"
	echo.

	echo Attendre 20s (démarrage d'Eureka et de config)...
	timeout /t 20 /nobreak > nul
	echo.

	echo Fermeture de Spring Cloud Gateway...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8081"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage de Spring Cloud Gateway...
	cd ../../back/gateway-service
	start cmd /k "title Démarrage de Spring Cloud Gateway... && mvn clean spring-boot:run"
	echo.

	echo Fermeture du service compte...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_COMPTE_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage du service compte...
	cd ../../back/compte-service
	start cmd /k "title Démarrage du service compte... && mvn clean spring-boot:run"
	echo.
	
	echo Fermeture du service tchat...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_TCHAT_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage du service tchat...
	cd ../../back/tchat-service
	start cmd /k "title Démarrage du service tchat... && mvn clean spring-boot:run"

	timeout /t 60 /nobreak > nul
	echo.
	echo ######################################################
	echo # Appuyer pour : fermer ces services et ces fenêtres #
	echo ######################################################
	echo.
	pause
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8081"') do set PID=%%a
	taskkill /F /pid %PID%
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8761"') do set PID=%%a
	taskkill /F /pid %PID%
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8888"') do set PID=%%a
	taskkill /F /pid %PID%
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_COMPTE_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_TCHAT_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	taskkill /f /im cmd.exe
exit