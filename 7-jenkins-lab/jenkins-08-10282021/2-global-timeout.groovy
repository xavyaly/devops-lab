// Global Timeout, Declarative Pipeline

pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS') 
    }
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
            }
        }
    }
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/declarative-pipeline
[Pipeline] {
[Pipeline] timeout
Timeout set to expire in 1 hr 0 min
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Example)
[Pipeline] echo
Hello World
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timeout
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
