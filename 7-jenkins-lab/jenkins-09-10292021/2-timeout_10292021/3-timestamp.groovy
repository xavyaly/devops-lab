pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
        //timeout(time:30, unit:'SECONDS')
        timestamps()
    }
    stages {
        stage("Deploy"){
            steps{
                sh 'echo hello man...'
                sleep(2)
                sh 'echo hi man...'
                sleep(2)
                sh 'echo howz it...'
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
[Pipeline] timestamps
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Deploy)
[Pipeline] sh
09:35:25  + echo hello man...
09:35:25  hello man...
[Pipeline] sleep
09:35:25  Sleeping for 2 sec
[Pipeline] sh
09:35:27  + echo hi man...
09:35:27  hi man...
[Pipeline] sleep
09:35:27  Sleeping for 2 sec
[Pipeline] sh
09:35:30  + echo howz it...
09:35:30  howz it...
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timestamps
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS




