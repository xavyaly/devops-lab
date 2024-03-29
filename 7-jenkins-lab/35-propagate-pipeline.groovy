/*
Build Trigger:
    Trigger jobs from pipeline
    How to trigger second build, even first build fails
    How to change build result
    Call a job by passing parameters
*/

// global level 
// this job is getting failed
// Job-Name: stage-level-preference-pipeline-job
pipeline {
    agent any 
    environment {
        BUILD_NUMBER = "global-level" // global level variable
    }
    stages {
        stage('user') {
            environment {
               MY_LEVEL = "stage-level" // stage level variable
            }
            steps {
                scirpt {
                    MY_LEVEL = "script-level" // script level variable
                }
            steps {
                echo " user pre-defined is $BUILD_NUMBER "
                }
            }   // end of steps 
        }   // end of stage 
    }   // end of stage
}   // end of pipeline

O/P: 
Failed 

//Trigger jobs from pipeline
// if we trigerring 2 jobs, if first job got failed, it wont trigger the 2nd job, so we use 
// propagate:false, so even if first job got failed second job will be triggered

pipeline {
    agent any
    stages {
        stage('Triggerjob') {
            steps {
                //build('job-2')  // absent; job failed no further execution
                build(job: 'stage-level-preference-pipeline-job', propagate: false) // present but getting failed
                build('job-1')  // present
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
[Pipeline] build (Building stage-level-preference-pipeline-job)
Scheduling project: stage-level-preference-pipeline-job
Starting building: stage-level-preference-pipeline-job #11
[Pipeline] build (Building job-1)
Scheduling project: job-1
Starting building: job-1 #6
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
