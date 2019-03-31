@echo off
@echo we have started compiling program
cd programs
javac abc.java > ..\output_abc.txt 2> ..\error_abc.txt && type ..\output_abc.txt || type ..\error_abc.txt
@echo Press Enter to Continue
PAUSE
EXIT