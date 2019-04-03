@echo off
@echo we have started compiling program %1
cd programs
javac %1.java > ..\output_%1.txt 2> ..\error_%1.txt && type ..\output_%1.txt || type ..\error_%1.txt
@echo Press Enter to Continue
PAUSE
EXIT