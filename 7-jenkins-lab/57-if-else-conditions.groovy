/*Conditional and Loop Statements*/

/*
IF Condition:

We can use Groovy coding functionalities using script {...} section.
*/

pipeline{
    agent any
    environment{
        Tools='Jenkins'     // hardcoded 
    }
    stages{
        stage('conditions'){
            steps{
                script{
                    if(Tools == 'Jenkins'){
                        echo 'Tools is jenkins'
                        }
                    else{
                        echo 'Tools is not jenkins '
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
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test-job
[Pipeline] {
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (conditions)
[Pipeline] script
[Pipeline] {
[Pipeline] echo
Tools is jenkins
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS


/*Wrong variable*/

pipeline{
    agent any
    environment{
        Tools='Jenkin'     // hardcoded 
    }
    stages{
        stage('conditions'){
            steps{
                script{
                    if(Tools == 'Jenkins'){
                        echo 'Tools is jenkins'
                        }
                    else{
                        echo 'Tools is not jenkins '
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
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test-job
[Pipeline] {
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (conditions)
[Pipeline] script
[Pipeline] {
[Pipeline] echo
Tools is not jenkins 
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

