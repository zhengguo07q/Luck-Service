@ECHO on


SET JDK_HOME=..\..\..\..\..\t1_tool\DevEnv\jdk1.8.0_05

SET PATH=%JDK_HOME%\bin;%PATH%

START .\component\luck-storage.cmd

ECHO start_config
START .\component\luck-config.cmd
PING -n 10 127.1>nul

ECHO start_register
START .\component\luck-register.cmd
PING -n 10 127.1>nul


ECHO start_monitoring
START .\component\luck-monitoring.cmd

ECHO start_gateway
START .\component\luck-gateway.cmd

ECHO start-service-account
#START .\component\luck-service-account.cmd

ECHO start-service-auth
#START .\component\luck-service-auth.cmd

ECHO start-service-notification
START .\component\luck-service-notification.cmd

ECHO start-service-statistics
START .\component\luck-service-statistics.cmd

ECHO start-service-web
#START .\component\luck-service-web.cmd


pause