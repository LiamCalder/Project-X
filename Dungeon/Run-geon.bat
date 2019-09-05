@echo off

cd /D "%~dp0" 
set JAVA_HOME=C:\Program Files\Java\*
set PATH=%JAVA_HOME%\bin;%PATH%

set SCRIPT="%TEMP%\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.vbs"

echo Set oWS = WScript.CreateObject("WScript.Shell") >> %SCRIPT%
echo sLinkFile = "%~dp0\Dungeon.lnk" >> %SCRIPT%
echo Set oLink = oWS.CreateShortcut(sLinkFile) >> %SCRIPT%
echo oLink.TargetPath = "%~dp0\run-geon.bat" >> %SCRIPT%
echo oLink.IconLocation = "%~dp0\De.ico" >> %SCRIPT%
echo oLink.Save >> %SCRIPT%

cscript /nologo %SCRIPT%
del %SCRIPT%

title Dungeon
javac --release 8 Dungeon.java
java Dungeon
exit