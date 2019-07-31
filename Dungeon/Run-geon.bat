@echo off
title Dungeon
for /f "tokens=*" %%a in ('findstr /l "realistic" Save.txt') do goto realistic
for /f "tokens=*" %%a in ('findstr /l "tutorial" Save.txt') do goto tutorial
:tutorial
javac DungeonT.java
java DungeonT
timeout /t 1 /nobreak
pause
exit
:realistic
javac Dungeon.java
java Dungeon
timeout /t 1 /nobreak
pause
exit
