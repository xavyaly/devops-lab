/*
Build Trigger:
    Trigger jobs from pipeline
    How to trigger second build, even first build fails
    How to change build result
    Call a job by passing parameters
*/

//How to change build result
// while using the below function, it will store the status in jobresult,
// now eventhough job failed, it will run trigger both job, but it will show unstable result status

pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Triggerjob') {
            steps {
                script{
                //build('job-2')  // absent; job failed no further execution
                jobresult = build(job: 'First-Job', propagate: false).result 
                if (jobresult == 'FAILURE') {
                    currentBuild.result='UNSTABLE'
                    }
                build('Second-Job')  // present
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
[Pipeline] { (Triggerjob)
[Pipeline] script
[Pipeline] {
[Pipeline] build (Building First-Job)
Scheduling project: First-Job
Starting building: First-Job #14
[Pipeline] build (Building Second-Job)
Scheduling project: Second-Job
Starting building: Second-Job #7
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: UNSTABLE


/*First-Job*/
// global level 
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

/*Second-Job*/
pipeline {
    agent any
    options { buildDiscarder(logRotator(numToKeepStr: '5')) }   
    stages {
        stage('Clean') {
            steps {
                sh 'echo Only 5 Builds'
            }
        }
    }      
}   // end of pipeline
