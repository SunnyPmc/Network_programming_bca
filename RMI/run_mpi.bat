@echo off
cd "C:\Users\Administrator\Documents\Everest college\6th sem\RMI"
set MPJ_HOME=C:\Users\Administrator\Documents\mpj-v0_44\mpj-v0_44
set PATH=%MPJ_HOME%\bin;%PATH%

mpjcompile.bat HelloMPI.java
mpjrun.bat -np 4 HelloMPI

pause
