pipeline {
    agent any
    stages {
        stage("Deploy"){
            options {
                retry(3)
                timeout(time:5, unit:'SECONDS')
                //timeout(time:5, unit:'MINUTES')
                //timeout(time:5, unit:'HOURS')
            }
            steps{
                sh 'echo hello!!!'
                sleep(10)
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
[Pipeline] { (Deploy)
[Pipeline] retry
[Pipeline] {
[Pipeline] timeout
Timeout set to expire in 5 sec
[Pipeline] {
[Pipeline] sh
+ echo hello!!!
hello!!!
[Pipeline] sleep
Sleeping for 10 sec
Cancelling nested steps due to timeout
[Pipeline] }
[Pipeline] // timeout
[Pipeline] }
Timeout has been exceeded
Retrying
[Pipeline] {
[Pipeline] sh
+ echo hello!!!
hello!!!
[Pipeline] sleep
Sleeping for 10 sec
[Pipeline] }
[Pipeline] // retry
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

