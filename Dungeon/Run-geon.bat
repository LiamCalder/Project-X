@echo off
cd /D "%~dp0" 
set PATH=%JAVA_HOME%\bin;%PATH%
title Dungeon
javac --release 8 Mode.java
java Mode
pause
