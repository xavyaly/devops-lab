/*Parallel
    Can i use multiple steps under same stage
    How to execute jobs at the same time ?
    How to execute stages parallel ?
    What is the use of FailFast ?
*/
/*How to execute jobs at the same time ?*/
/*Parallel builds -- it will trigger the build parallely*/

pipeline {
    agent any 
    stages {
        stage('Build') {
            parallel {      // induced parallel
                stage('Job-1') {
                    steps {
                        sh 'echo Job-1 executed parallel with Job-2'
                    }
                }
                stage('Job-2') {
                    steps {
                        sh 'echo Job-2 executed parallel with Job-1'
                    }
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
[Pipeline] { (Build)
[Pipeline] parallel
[Pipeline] { (Branch: Job-1)
[Pipeline] { (Branch: Job-2)
[Pipeline] stage
[Pipeline] { (Job-1)
[Pipeline] stage
[Pipeline] { (Job-2)
[Pipeline] sh
[Pipeline] sh
+ echo Job-1 executed parallel with Job-2
Job-1 executed parallel with Job-2
[Pipeline] }
+ echo Job-2 executed parallel with Job-1
Job-2 executed parallel with Job-1
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // parallel
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
