// clean workspace 
// https://stackoverflow.com/questions/37468455/jenkins-pipeline-wipe-out-workspace
	
pipeline {
    agent any
    stages {
        stage('Clean WorkSpace') {
            steps {
                echo 'Hello World'
            }
        }
    }
    post { 
        always { 
            cleanWs()
        }
    }
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/declarative-pipeline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Example)
[Pipeline] echo
Hello World
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Declarative: Post Actions)
[Pipeline] cleanWs
[WS-CLEANUP] Deleting project workspace...
[WS-CLEANUP] Deferred wipeout is used...
[WS-CLEANUP] done
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
