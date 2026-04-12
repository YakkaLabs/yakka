#!/bin/bash

/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-gateway.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-oauth.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-base.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-system.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-ai.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-im.sh stop
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-ws.sh stop