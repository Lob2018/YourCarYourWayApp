@echo off
	chcp 65001
	color 0A
	:: STOP YOUR CAR YOUR WAY
	title STOP YOUR CAR YOUR WAY
	echo.
	echo ############################################################################
	echo # ATTENTION : ce script tue les PIDs associés aux ports de l'application ! #
	echo ############################################################################
	pause
	echo.
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8081"') do set PID=%%a
	taskkill /F /pid %PID%
	echo.
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8761"') do set PID=%%a
	taskkill /F /pid %PID%
	echo.
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":8888"') do set PID=%%a
	taskkill /F /pid %PID%
	echo.
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_COMPTE_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	echo.
	for /f "tokens=5" %%a in ('netstat -ano ^| find ":%YCYW_YL_SERVICE_TCHAT_SERVER_PORT%"') do set PID=%%a
	taskkill /F /pid %PID%
	timeout /t 2 /nobreak > nul
exit