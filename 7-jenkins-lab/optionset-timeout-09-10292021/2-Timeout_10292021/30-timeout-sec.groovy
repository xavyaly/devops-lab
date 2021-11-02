pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
        timeout(time:30, unit:'SECONDS')
    }
    stages {
        stage("Deploy"){
            steps{
                sh 'echo hello!!!'
                sleep(10)
            }
        }
    }
}

// its aborted after the timelimit 

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test
[Pipeline] {
[Pipeline] timeout
Timeout set to expire in 30 sec
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] sh
+ echo hello!!!
hello!!!
[Pipeline] sleep
Sleeping for 10 sec
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timeout
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
