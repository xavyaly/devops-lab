/*
Demo : check build number even or Odd
*/

pipeline{
    agent any
    environment{
        Tools='Jenkins'
    }
    stages{
        stage('conditions'){
            steps{
                script{
                    int buildno="$BUILD_NUMBER"
                    if(buildno %2 == 0){
                        echo 'builno is even'
                    }else{
                        echo 'buildno is odd'
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
builno is even
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

/**/
pipeline{
    agent any
    environment{
        Tools='Jenkins'
    }
    stages{
        stage('conditions'){
            steps{
                script{
                    int buildno="$BUILD_NUMBER"
                    if(buildno %2 == 0){
                        echo 'builno is even'
                    }else{
                        echo 'buildno is odd'
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
buildno is odd
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


