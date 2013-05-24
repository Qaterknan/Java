SET /p nazev="File name (with .java) "
javac %nazev%
set /p name="Class name (without .class) "
java %name%
pause