@echo off
@echo We are running task
cd programs
javac abc.java > output_abc.txt 2>&1
java abc> ..\output_abc.txt 2>&1
@echo Press Enter to Continue
PAUSE
EXIT