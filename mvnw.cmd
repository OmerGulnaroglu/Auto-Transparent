@echo off
setlocal

if "%MAVEN_BATCH_ECHO%"=="on" echo %MAVEN_BATCH_ECHO%
if "%HOME%"=="" (set "HOME=%HOMEDRIVE%%HOMEPATH%")

if not "%JAVA_HOME%"=="" goto OkJHome
echo Error: JAVA_HOME not found in your environment. >&2
echo Please set JAVA_HOME to your JDK installation path. >&2
goto error

:OkJHome
if exist "%JAVA_HOME%\bin\java.exe" goto init
echo Error: JAVA_HOME is set to an invalid directory: "%JAVA_HOME%" >&2
goto error

:init
set MAVEN_PROJECTBASEDIR=%MAVEN_BASEDIR%
if not "%MAVEN_PROJECTBASEDIR%"=="" goto endDetectBaseDir

set EXEC_DIR=%CD%
set WDIR=%EXEC_DIR%
:findBaseDir
if exist "%WDIR%\.mvn" goto baseDirFound
cd ..
if "%WDIR%"=="%CD%" goto baseDirNotFound
set WDIR=%CD%
goto findBaseDir

:baseDirFound
set MAVEN_PROJECTBASEDIR=%WDIR%
cd "%EXEC_DIR%"
goto endDetectBaseDir

:baseDirNotFound
set MAVEN_PROJECTBASEDIR=%EXEC_DIR%
cd "%EXEC_DIR%"

:endDetectBaseDir
set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
set WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
set WRAPPER_URL=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.2/maven-wrapper-3.3.2.jar

for /F "usebackq tokens=1,2 delims==" %%A in ("%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties") do (
 if "%%A"=="wrapperUrl" set WRAPPER_URL=%%B
)

if exist %WRAPPER_JAR% goto run
echo Maven wrapper JAR not found, downloading...
powershell -Command "& { [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object System.Net.WebClient).DownloadFile('%WRAPPER_URL%', '%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar') }"

:run
"%JAVA_HOME%\bin\java.exe" ^
 -classpath %WRAPPER_JAR% ^
 "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECTBASEDIR%" ^
 %WRAPPER_LAUNCHER% %*
if ERRORLEVEL 1 goto error
goto end

:error
endlocal
exit /b 1

:end
endlocal
exit /b 0
