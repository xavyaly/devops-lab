// If any error or timeout it will execute 3 times

pipeline {
    agent any
    options {
        retry(3)
        //timeout(time: 5, unit: 'SECONDS')
        }
    stages {
        stage("Deploy"){
            steps{
                sh 'echo hello!!!'
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
[Pipeline] retry
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] sh
+ echo hello!!!
hello!!!
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // retry
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

