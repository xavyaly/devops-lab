pipeline {
    agent any 
    stages {
        stage("Home Path"){
            environment {
                ENV_PATH = "/home/ubuntu"
            }
            steps {
                echo "Current User Path is ${ENV_PATH}"
            }
        }
    }
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Home Path)
[Pipeline] withEnv
[Pipeline] {
[Pipeline] echo
Current User Path is /home/ubuntu
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
