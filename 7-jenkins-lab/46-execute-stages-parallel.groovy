/*Parallel
    Can i use multiple steps under same stage
    How to execute jobs at the same time ?
    How to execute stages parallel ?
    What is the use of FailFast ?
*/

/*How to execute stages parallel ?*/
/*Parallel Stages -- it will trigger the */

pipeline {
    agent any
    options{
        timestamps()
    }
    stages {
        stage("stage1") {
            parallel{
                stage('stage1job1'){
                    steps{
                        echo "stage1job1 executed parallel with stage1job2"
                        sleep(10)
                    }
                }
                stage('stage1job2'){
                    steps{
                        echo "stage1job2 executed parallel with stage1job1"
                        sleep(10)
                    }
                }
            }
        }
        stage("stage2") {
            parallel{
                stage('stage2job1'){
                    steps{
                        echo "stage2job1 executed parallel with stage2job2"
                        sleep(5)
                    }
                }
                stage('stage2job2'){
                    steps{
                        echo "stage2job2 executed parallel with stage2job1"
                        sleep(5)
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
[Pipeline] timestamps
[Pipeline] {
[Pipeline] stage
[Pipeline] { (stage1)
[Pipeline] parallel
[Pipeline] { (Branch: stage1job1)
[Pipeline] { (Branch: stage1job2)
[Pipeline] stage
[Pipeline] { (stage1job1)
[Pipeline] stage
[Pipeline] { (stage1job2)
[Pipeline] echo
02:59:33  stage1job1 executed parallel with stage1job2
[Pipeline] sleep
02:59:33  Sleeping for 10 sec
[Pipeline] echo
02:59:33  stage1job2 executed parallel with stage1job1
[Pipeline] sleep
02:59:33  Sleeping for 10 sec
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // parallel
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (stage2)
[Pipeline] parallel
[Pipeline] { (Branch: stage2job1)
[Pipeline] { (Branch: stage2job2)
[Pipeline] stage
[Pipeline] { (stage2job1)
[Pipeline] stage
[Pipeline] { (stage2job2)
[Pipeline] echo
02:59:43  stage2job1 executed parallel with stage2job2
[Pipeline] sleep
02:59:43  Sleeping for 5 sec
[Pipeline] echo
02:59:43  stage2job2 executed parallel with stage2job1
[Pipeline] sleep
02:59:43  Sleeping for 5 sec
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // parallel
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timestamps
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
