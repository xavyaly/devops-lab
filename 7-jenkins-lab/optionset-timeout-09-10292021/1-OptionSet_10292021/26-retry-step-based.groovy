/*
Option Set:
    Stage Level 
    Pipe Level

*/

pipeline {
    agent any
    stages {
        stage("Deploy"){
            steps{
                retry(3){
                sh 'echo hello!!!'
                }
            }
        }
    }
}


O/P:

