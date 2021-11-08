/*
If you want to run specific version of tools to use in pipeline for specific job, so we using tools.

Steps:
Manage Jenkins -> Global Tool Configuration -> Maven -> Maven installations -> Click on Add Maven
Maven -> Name (Maven3.8.2) -> Select the checkbox "Install Automatically" -> Select the Version "3.8.2"
Click on Save

*/

/*Different or Lower version maven*/

pipeline{
    agent any
    tools{
        maven 'Maven3.8.2'
        }
    stages{
        stage('tools_version'){
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
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (tools_version)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ mvn --version
Apache Maven 3.8.2 (ea98e05a04480131370aa0c110b8c54cf726c06f)
Maven home: /var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven3.8.2
Java version: 1.8.0_292, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.4.0-1128-aws", arch: "amd64", family: "unix"
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
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

