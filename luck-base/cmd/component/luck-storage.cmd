echo off
title=luck-storage
..\..\..\..\..\..\t1_tool\DevEnv\MongoDB\Server\3.4\bin\mongod --dbpath ..\..\..\..\..\..\t1_tool\DevLib\MongodDb -logpath=..\..\..\..\..\..\t1_tool\DevLib\MongodDbLog\log --profile=1 --slowms=1
pause