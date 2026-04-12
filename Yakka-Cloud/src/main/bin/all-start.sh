#!/bin/bash

/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-gateway.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-oauth.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-base.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-system.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-ai.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-im.sh
/bin/bash /home/jenkins/work/workspace/yakka-cloud/src/main/bin/restart-yakka-ws.sh