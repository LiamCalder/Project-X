@echo off
cd /D "%~dp0" 
set JAVA_HOME=C:\Program Files\Java\*
set PATH=%JAVA_HOME%\bin;%PATH%
title Dungeon
javac --release 8 Dungeon.java
java Dungeon
exit