/*
Build Trigger:
    Trigger jobs from pipeline
    How to trigger second build, even first build fails
    How to change build result
    Call a job by passing parameters
*/

//Trigger jobs from pipeline
//Condition: 'job-1' should be present

pipeline {
    agent any
    stages {
        stage('Triggerjob') {
            steps {
                build('job-1')  // job should be present
                //build('job-1')
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
[Pipeline] { (Triggerjob)
[Pipeline] build (Building job-1)
Scheduling project: job-1
Starting building: job-1 #2
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

-----------------------------------------------------------------------------------------------





