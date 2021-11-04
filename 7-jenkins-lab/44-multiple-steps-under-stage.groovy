/*Parallel
    Can i use multiple steps under same stage
    How to execute jobs at the same time ?
    How to execute stages parallel ?
    What is the use of FailFast ?
*/

/*Can i use multiple steps under same stage ?? */

/*Answer: No*/

/*Single Step: SUCCESS*/
pipeline{
    agent any 
    stages {
        stage("cron") {
            steps {
                echo "step1"
            }
            /*
            steps {
                echo "step2"
            }
            */
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
[Pipeline] { (cron)
[Pipeline] echo
step1
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

/*Multiple Step: SUCCESS*/
pipeline{
    agent any 
    stages {
        stage("cron") {
            steps {
                echo "step1"
            }
            steps {
                echo "step2"
            }
        }
    }
}

O/P:

Started by user xavyaly
org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:
WorkflowScript: 15: Multiple occurrences of the steps section @ line 15, column 9.
           stage("cron") {
           ^

1 error

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
