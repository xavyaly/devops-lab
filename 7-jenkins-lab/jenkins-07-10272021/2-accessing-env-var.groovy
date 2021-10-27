pipeline {
    agent any 

    stages {
        stage("Env Varibales...") {
            steps {
                echo "The BUILD_NUMBER = ${env.BUILD_NUMBER}"   // env is not mandatory
                echo "One can also use \${BUILD_NUMBER} -> ${BUILD_NUMBER}"
                sh 'echo "I can access the $BUILD_NUMBER in shell command as well"'
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
[Pipeline] { (Env Varibales...)
[Pipeline] echo
The BUILD_NUMBER = 2
[Pipeline] echo
One can also use ${BUILD_NUMBER} -> 2
[Pipeline] sh
+ echo I can access the 2 in shell command as well
I can access the 2 in shell command as well
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
