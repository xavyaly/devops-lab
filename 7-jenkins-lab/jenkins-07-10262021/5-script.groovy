pipeline {
    agent any 
    stages {
        stage("User-Group"){
            steps {
                script {    // sudo apt install gradle
                    env.USER_GROUP = "users"
                }
                sh "echo Current user group is: $USER_GROUP"

                //block
                withEnv(["USER_PWD=secret","USER_IS_ADMIN=false"]){
                    echo "Current user password is: ${env.USER_PWD}"
                    sh "echo Current user admin is? $USER_IS_ADMIN"
                }
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
[Pipeline] { (User-Group)
[Pipeline] script
[Pipeline] {
[Pipeline] }
[Pipeline] // script
[Pipeline] sh
+ echo Current user group is: users
Current user group is: users
[Pipeline] withEnv
[Pipeline] {
[Pipeline] echo
Current user password is: secret
[Pipeline] sh
+ echo Current user admin is? false
Current user admin is? false
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
