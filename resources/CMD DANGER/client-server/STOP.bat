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
	timeout /t 2 /nobreak > nul
exit