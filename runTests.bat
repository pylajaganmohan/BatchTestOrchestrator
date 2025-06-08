@echo off
cd C:\Users\pylaj\eclipse-workspace\Test
CALL mvn test -Dtest=testFiles.Test1
CALL mvn test -Dtest=testFiles.Test2
CALL mvn test -Dtest=testFiles.Test3
