/*
If you want to run specific version of tools to use in pipeline for specific job, so we using tools.

Steps:
Manage Jenkins -> Global Tool Configuration -> Maven -> Maven installations -> Click on Add Maven
Maven -> Name (Maven3.8.3) -> Select the checkbox "Install Automatically" -> Select the Version "3.8.3"
Click on Save

Ex: maven in two version
*/

pipeline{
    agent any
    options{
        buildDiscarder(logRotator(numToKeepStr: '5')) 
        timestamps()
    }
    tools{
        maven 'Maven3.8.3'
    }
    stages{
        stage('tools_versi]on'){
            steps{
                sh 'mvn --version'
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
[Pipeline] timestamps
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (tools_versi]on)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
02:56:36  + mvn --version
02:56:36  Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
02:56:36  Maven home: /var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven3.8.3
02:56:36  Java version: 1.8.0_292, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
02:56:36  Default locale: en_US, platform encoding: UTF-8
02:56:36  OS name: "linux", version: "4.4.0-1128-aws", arch: "amd64", family: "unix"
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // timestamps
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS


ubuntu@jenkins-master:~$ mvn --v
Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /opt/maven
Java version: 1.8.0_292, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.4.0-1128-aws", arch: "amd64", family: "unix"
ubuntu@jenkins-master:~$
