/*
Demo: For loop
*/

pipeline{
    agent any
    environment{
        Tools='Jenkins'
    }
    stages{
        stage('conditio]ns'){
            steps{
                script{
                    for(i=0;i<=5;i++){
                        println i
                        if(i %2 == 0){
                        echo 'builno is even'
                        }else{
                        echo 'buildno is odd'
                        }
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
[Pipeline] { (conditio]ns)
[Pipeline] script
[Pipeline] {
[Pipeline] echo
0
[Pipeline] echo
builno is even
[Pipeline] echo
1
[Pipeline] echo
buildno is odd
[Pipeline] echo
2
[Pipeline] echo
builno is even
[Pipeline] echo
3
[Pipeline] echo
buildno is odd
[Pipeline] echo
4
[Pipeline] echo
builno is even
[Pipeline] echo
5
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


/**/

pipeline{
    agent any
    environment{
        Tools='Jenkins'
    }
    stages{
        stage('conditio]ns'){
            steps{
                script{
                    for(i=0;i<5;i++){
                        println i
                        if(i %2 == 0){
                        echo 'builno is even'
                        }else{
                        echo 'buildno is odd'
                        }
                    }   // end of for loop 
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
[Pipeline] { (conditio]ns)
[Pipeline] script
[Pipeline] {
[Pipeline] echo
0
[Pipeline] echo
builno is even
[Pipeline] echo
1
[Pipeline] echo
buildno is odd
[Pipeline] echo
2
[Pipeline] echo
builno is even
[Pipeline] echo
3
[Pipeline] echo
buildno is odd
[Pipeline] echo
4
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


