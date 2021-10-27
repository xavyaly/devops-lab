pipeline {
    agent any 
    environment {
        USER_FIRST_NAME = "XAVY"
        USER_LAST_NAME = "ALY"
        USER_ID = 35
    }
    stages {
        stage("Concatenate Env Var"){
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
[Pipeline] { (Concatenate Env Var)
[Pipeline] echo
FULL_NAME is XAVYALY
[Pipeline] echo
Current User id is: 35 (type: class java.lang.String)
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
