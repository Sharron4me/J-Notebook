@echo off
@echo we have started compiling program
cd programs
javac abc.java > ..\output_abc.txt 2>&1
@echo Press Enter to Continue
PAUSE
EXIT