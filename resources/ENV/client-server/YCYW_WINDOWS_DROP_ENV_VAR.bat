@echo off
	color 0A
	:: YCYW
	REG delete "HKCU\Environment" /F /V "YCYW_YL_TOKEN_SECRET"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_TOKEN_ISSUER"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_POSTGRES_USERNAME"
	REG delete "HKCU\Environment" /F /V "YCYW_YL_POSTGRES_PASSWORD"
exit