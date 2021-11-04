/*Parallel
    Can i use multiple steps under same stage
    How to execute jobs at the same time ?
    How to execute stages parallel ?
    What is the use of FailFast ?
*/

/*failFast*/
/*
In parallel, eventhough if any job got failed, it won't stop, it will execute other job. 
If we want any job to be failed, it should stop the other build means we need to use failFast
*/

/*Commented FailFast*/
pipeline {
    agent any
    options{
        timestamps()
    }
    stages {
        stage("Build") {
            //FailFast true       // FailFast
            parallel{
                stage('stage1job1'){
                    steps{
                        echo "stage1job1"
                        sleep(10)
                    }
                }
                stage('stage1job2'){
                    steps{
                        echo "stage1job2"
                        sleep(10)
                    }
                }
                stage('stage2job1'){
                    steps{
                        echo "stage2job1"
                        sleep(5)
                    }
                }
                stage('stage2job2'){
                    steps{
                        echo "stage2job2"
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
[Pipeline] { (Build)
[Pipeline] parallel
[Pipeline] { (Branch: stage1job1)
[Pipeline] { (Branch: stage1job2)
[Pipeline] { (Branch: stage2job1)
[Pipeline] { (Branch: stage2job2)
[Pipeline] stage
[Pipeline] { (stage1job1)
[Pipeline] stage
[Pipeline] { (stage1job2)
[Pipeline] stage
[Pipeline] { (stage2job1)
[Pipeline] stage
[Pipeline] { (stage2job2)
[Pipeline] echo
08:39:58  stage1job1
[Pipeline] sleep
08:39:58  Sleeping for 10 sec
[Pipeline] echo
08:39:58  stage1job2
[Pipeline] sleep
08:39:58  Sleeping for 10 sec
[Pipeline] echo
08:39:58  stage2job1
[Pipeline] sleep
08:39:58  Sleeping for 5 sec
[Pipeline] echo
08:39:58  stage2job2
[Pipeline] sleep
08:39:58  Sleeping for 5 sec
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
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

/*Job Failed because of FailFast Flag*/
pipeline {
    agent any
    options{
        timestamps()
    }
    stages {
        stage("Build") {
            FailFast true       // FailFast
            parallel{
                stage('stage1job1'){
                    steps{
                        echo "stage1job1"''
                        sleep(10)
                    }
                }
                stage('stage1job2'){
                    steps{
                        echo "stage1job2"
                        sleep(10)
                    }
                }
                stage('stage2job1'){
                    steps{
                        echo "stage2job1"
                        sleep(5)
                    }
                }
                stage('stage2job2'){
                    steps{
                        echo "stage2job2"
                        sleep(5)
                    }
                }
            }
        }
    }
}

O/P: 
Started by user xavyaly
org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
WorkflowScript: 7: Unknown stage section "FailFast". Starting with version 0.5, steps in a stage must be in a ‘steps’ block. @ line 7, column 9.
           stage("Build") {
           ^

WorkflowScript: 12: Expected a step @ line 12, column 25.
                           echo "stage1job1"''
                           ^

2 errors

	at org.codehaus.groovy.control.ErrorCollector.failIfErrors(ErrorCollector.java:310)
	at org.codehaus.groovy.control.CompilationUnit.applyToPrimaryClassNodes(CompilationUnit.java:1085)
	at org.codehaus.groovy.control.CompilationUnit.doPhaseOperation(CompilationUnit.java:603)
	at org.codehaus.groovy.control.CompilationUnit.processPhaseOperations(CompilationUnit.java:581)
	at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:558)
	at groovy.lang.GroovyClassLoader.doParseClass(GroovyClassLoader.java:298)
	at groovy.lang.GroovyClassLoader.parseClass(GroovyClassLoader.java:268)
	at groovy.lang.GroovyShell.parseClass(GroovyShell.java:688)
	at groovy.lang.GroovyShell.parse(GroovyShell.java:700)
	at org.jenkinsci.plugins.workflow.cps.CpsGroovyShell.doParse(CpsGroovyShell.java:142)
	at org.jenkinsci.plugins.workflow.cps.CpsGroovyShell.reparse(CpsGroovyShell.java:127)
	at org.jenkinsci.plugins.workflow.cps.CpsFlowExecution.parseScript(CpsFlowExecution.java:571)
	at org.jenkinsci.plugins.workflow.cps.CpsFlowExecution.start(CpsFlowExecution.java:523)
	at org.jenkinsci.plugins.workflow.job.WorkflowRun.run(WorkflowRun.java:334)
	at hudson.model.ResourceController.execute(ResourceController.java:99)
	at hudson.model.Executor.run(Executor.java:432)
Finished: FAILURE



/*https://www.jenkins.io/doc/book/pipeline/syntax/*/

pipeline {
    agent any
    stages {
        stage('Non-Parallel Stage') {
            steps {
                echo 'This stage will be executed first.'
            }
        }
        stage('Parallel Stage') {
            when {
                branch 'master'
            }
            failFast true
            parallel {
                stage('Branch A') {
                    agent {
                        label "for-branch-a"
                    }
                    steps {
                        echo "On Branch A"
                    }
                }
                stage('Branch B') {
                    agent {
                        label "for-branch-b"
                    }
                    steps {
                        echo "On Branch B"
                    }
                }
                stage('Branch C') {
                    agent {
                        label "for-branch-c"
                    }
                    stages {
                        stage('Nested 1') {
                            steps {
                                echo "In stage Nested 1 within Branch C"
                            }
                        }
                        stage('Nested 2') {
                            steps {
                                echo "In stage Nested 2 within Branch C"
                            }
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
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Non-Parallel Stage)
[Pipeline] echo
This stage will be executed first.
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Parallel Stage)
Stage "Parallel Stage" skipped due to when conditional
[Pipeline] parallel
[Pipeline] { (Branch: Branch A)
[Pipeline] { (Branch: Branch B)
[Pipeline] { (Branch: Branch C)
[Pipeline] stage
[Pipeline] { (Branch A)
[Pipeline] stage
[Pipeline] { (Branch B)
[Pipeline] stage
[Pipeline] { (Branch C)
Stage "Branch A" skipped due to when conditional
[Pipeline] }
Stage "Branch B" skipped due to when conditional
[Pipeline] }
Stage "Branch C" skipped due to when conditional
[Pipeline] // stage
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] stage
[Pipeline] { (Nested 1)
Stage "Branch C" skipped due to when conditional
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Nested 2)
Stage "Branch C" skipped due to when conditional
[Pipeline] }
[Pipeline] // stage
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


/*parallelAlwaysFailFast()*/
pipeline {
    agent any
    options {
        parallelsAlwaysFailFast()
    }
    stages {
        stage('Non-Parallel Stage') {
            steps {
                echo 'This stage will be executed first.'
            }
        }
        stage('Parallel Stage') {
            when {
                branch 'master'
            }
            parallel {
                stage('Branch A') {
                    agent {
                        label "for-branch-a"
                    }
                    steps {
                        echo "On Branch A"
                    }
                }
                stage('Branch B') {
                    agent {
                        label "for-branch-b"
                    }
                    steps {
                        echo "On Branch B"
                    }
                }
                stage('Branch C') {
                    agent {
                        label "for-branch-c"
                    }
                    stages {
                        stage('Nested 1') {
                            steps {
                                echo "In stage Nested 1 within Branch C"
                            }
                        }
                        stage('Nested 2') {
                            steps {
                                echo "In stage Nested 2 within Branch C"
                            }
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
Running on Jenkins in /var/lib/jenkins/workspace/pipeline-test
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Non-Parallel Stage)
[Pipeline] echo
This stage will be executed first.
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Parallel Stage)
Stage "Parallel Stage" skipped due to when conditional
[Pipeline] parallel
[Pipeline] { (Branch: Branch A)
[Pipeline] { (Branch: Branch B)
[Pipeline] { (Branch: Branch C)
[Pipeline] stage
[Pipeline] { (Branch A)
[Pipeline] stage
[Pipeline] { (Branch B)
[Pipeline] stage
[Pipeline] { (Branch C)
Stage "Branch A" skipped due to when conditional
[Pipeline] }
Stage "Branch B" skipped due to when conditional
[Pipeline] }
Stage "Branch C" skipped due to when conditional
[Pipeline] // stage
[Pipeline] // stage
[Pipeline] }
[Pipeline] }
[Pipeline] stage
[Pipeline] { (Nested 1)
Stage "Branch C" skipped due to when conditional
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Nested 2)
Stage "Branch C" skipped due to when conditional
[Pipeline] }
[Pipeline] // stage
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
