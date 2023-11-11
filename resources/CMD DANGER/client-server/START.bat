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
	echo Fermeture de YCYW...
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8081"') do set PID=%%a
	taskkill /F /pid %PID%
	echo Démarrage de YCYW...
	cd ../../../back
	start cmd /k "title Démarrage de YCYW... && mvn clean spring-boot:run"
	echo.
	echo ##############################
	echo # Appuyer pour : fermer YCYW #
	echo ##############################
	echo.
	pause
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8081"') do set PID=%%a
	taskkill /F /pid %PID%	
	taskkill /f /im cmd.exe
exit