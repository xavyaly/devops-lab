pipeline {
    agent any 
    stages {
        stage("List all enviornment variables...") {
            steps {
                sh "printenv | sort"
            }
        }
    }
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/printenv-pipleline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (List all enviornment variables...)
[Pipeline] sh
+ sort
+ printenv
BUILD_DISPLAY_NAME=#12
BUILD_ID=12
BUILD_NUMBER=12
BUILD_TAG=jenkins-printenv-pipleline-12
BUILD_URL=http://13.233.133.97:8080/job/printenv-pipleline/12/
CI=true
EXECUTOR_NUMBER=0
HOME=/var/lib/jenkins
HUDSON_COOKIE=f29b3470-e1ba-41be-bbc6-6ea341c958d2
HUDSON_HOME=/var/lib/jenkins
HUDSON_SERVER_COOKIE=bb4ad9b49c6de07d
HUDSON_URL=http://13.233.133.97:8080/
JENKINS_HOME=/var/lib/jenkins
JENKINS_NODE_COOKIE=4f513df0-9f10-41c2-9289-1960ff5920d8
JENKINS_SERVER_COOKIE=durable-e0dfff0f3fb20d5c97d6800982dc929c5c70051cbc0d75bf8d94084922dfe208
JENKINS_URL=http://13.233.133.97:8080/
JOB_BASE_NAME=printenv-pipleline
JOB_DISPLAY_URL=http://13.233.133.97:8080/job/printenv-pipleline/display/redirect
JOB_NAME=printenv-pipleline
JOB_URL=http://13.233.133.97:8080/job/printenv-pipleline/
LANG=en_US.UTF-8
LD_LIBRARY_PATH=/usr/local/cuda/lib:/usr/local/cuda/lib64:/usr/local/cuda/extras/CUPTI/lib64:/opt/amazon/efa/lib:/opt/amazon/openmpi/lib:/usr/local/lib:/usr/lib:
LOGNAME=jenkins
MAIL=/var/mail/jenkins
MANPATH=/opt/aws/neuron/share/man:
MODULEPATH=/etc/environment-modules/modules:/usr/share/modules/versions:/usr/Modules/$MODULE_VERSION/modulefiles:/usr/share/modules/modulefiles
MODULESHOME=/usr/share/modules
MODULE_VERSION=3.2.10
MODULE_VERSION_STACK=3.2.10
NODE_LABELS=built-in
NODE_NAME=built-in
PATH=/opt/amazon/openmpi/bin/:/opt/amazon/efa/bin/:/home/ubuntu/anaconda3/condabin:/home/ubuntu/.dl_binaries/bin:/usr/local/cuda/bin:/opt/aws/neuron/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin
PKG_CONFIG_PATH=/usr/local/lib/pkgconfig:
PWD=/var/lib/jenkins/workspace/printenv-pipleline
RUN_ARTIFACTS_DISPLAY_URL=http://13.233.133.97:8080/job/printenv-pipleline/12/display/redirect?page=artifacts
RUN_CHANGES_DISPLAY_URL=http://13.233.133.97:8080/job/printenv-pipleline/12/display/redirect?page=changes
RUN_DISPLAY_URL=http://13.233.133.97:8080/job/printenv-pipleline/12/display/redirect
RUN_TESTS_DISPLAY_URL=http://13.233.133.97:8080/job/printenv-pipleline/12/display/redirect?page=tests
SHELL=/bin/bash
SHLVL=1
STAGE_NAME=List all enviornment variables...
USER=jenkins
_=/usr/bin/daemon
WORKSPACE_TMP=/var/lib/jenkins/workspace/printenv-pipleline@tmp
WORKSPACE=/var/lib/jenkins/workspace/printenv-pipleline
XDG_DATA_DIRS=/usr/local/share:/usr/share:/var/lib/snapd/desktop
XDG_RUNTIME_DIR=/run/user/115
XDG_SESSION_ID=c1
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
