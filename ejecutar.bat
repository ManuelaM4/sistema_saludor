@echo off
setlocal
cd /d "%~dp0"
call mvnw.cmd -q javafx:run
endlocal
