@echo off
	color 0A
	:: SERVICE COMPTE
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_SERVER_PORT"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_TOKEN_SECRET"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_TOKEN_ISSUER"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_POSTGRES_DBNAME"	
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_POSTGRES_PORT"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_POSTGRES_USERNAME"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_COMPTE_POSTGRES_PASSWORD"
	:: SERVICE TCHAT
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_TCHAT_SERVER_PORT"		
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_TCHAT_POSTGRES_DBNAME"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_TCHAT_POSTGRES_PORT"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_TCHAT_POSTGRES_USERNAME"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_SERVICE_TCHAT_POSTGRES_PASSWORD"
exit