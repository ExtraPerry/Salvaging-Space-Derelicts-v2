@echo off
Echo cd "%~dp0"
cd %~dp0
PAUSE

@echo on
SET PATH="C:\Program Files\BlueJ\jdk\bin";%PATH%

PAUSE

javadoc -d userdoc -author -version *.java

PAUSE