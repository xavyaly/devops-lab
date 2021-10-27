pipeline {
    agent any 
    environment {
        USER_FIRST_NAME = "XAVY"
        USER_LAST_NAME = "ALY"
        USER_ID = 35
    }
    stages {
        stage("Override Stage Variables"){
            environment {
                USER_ID = 32    // override, priority
            }
            steps {
                echo "FULL_NAME is ${env.USER_FIRST_NAME + env.USER_LAST_NAME}"
                echo "Current User id is: ${env.USER_ID} (type: ${env.USER_ID.class})"
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
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Override Stage Variables)
[Pipeline] withEnv
[Pipeline] {
[Pipeline] echo
FULL_NAME is XAVYALY
[Pipeline] echo
Current User id is: 32 (type: class java.lang.String)
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
