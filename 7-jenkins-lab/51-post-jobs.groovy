/*When Job Passed*/

pipeline {
    agent any
    options{
        timestamps()
    }
    stages {
        stage("stage1") {
            steps{
                sh "ls -l"
            }
            post{
                always{
                    echo " action always "
                    }
                changed{
                    echo " action always Changed from previous state"
                    }
                fixed{
                    echo " action Fixed when previous state is failure"
                    }
                regression{
                    echo " action when current state is fail/unstable/aborted , previous state is success"
                    }
                aborted{
                    echo " action always aborted"
                    }
                failure{
                    echo " action always failure"
                    }
                success{
                    echo " action always success"
                    }
                unstable{
                    echo " action unstable"
                    }
                cleanup{
                    echo " action similar like always , it is using to cleanup folder or workspace"
                    }
                }
        }
    }   // end to stages
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/post-jobs
[Pipeline] {
[Pipeline] timestamps
[Pipeline] {
[Pipeline] stage
[Pipeline] { (stage1)
[Pipeline] sh
07:02:12  + ls -l
07:02:12  total 0
Post stage
[Pipeline] echo
07:02:12   action always 
[Pipeline] echo
07:02:12   action always Changed from previous state
[Pipeline] echo
07:02:12   action always success
[Pipeline] echo
07:02:12   action similar like always , it is using to cleanup folder or workspace
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timestamps
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

/*When Job got failed*/

pipeline {
    agent any
    options{
        timestamps()
    }
    stages {
        stage("stage1") {
            steps{
                sh "ls -l'" // code failed
            }
            post{
                always{
                    echo " action always "
                    }
                changed{
                    echo " action always Changed from previous state"
                    }
                fixed{
                    echo " action Fixed when previous state is failure"
                    }
                regression{
                    echo " action when current state is fail/unstable/aborted , previous state is success"
                    }
                aborted{
                    echo " action always aborted"
                    }
                failure{
                    echo " action always failure"
                    }
                success{
                    echo " action always success"
                    }
                unstable{
                    echo " action unstable"
                    }
                cleanup{
                    echo " action similar like always , it is using to cleanup folder or workspace"
                    }
                }
        }
    }   // end to stages
}

O/P:

Started by user xavyaly
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /var/lib/jenkins/workspace/post-jobs
[Pipeline] {
[Pipeline] timestamps
[Pipeline] {
[Pipeline] stage
[Pipeline] { (stage1)
[Pipeline] sh
07:04:31  /var/lib/jenkins/workspace/post-jobs@tmp/durable-5fb0cdc9/script.sh: 1: /var/lib/jenkins/workspace/post-jobs@tmp/durable-5fb0cdc9/script.sh: Syntax error: Unterminated quoted string
Post stage
[Pipeline] echo
07:04:31   action always 
[Pipeline] echo
07:04:31   action always Changed from previous state
[Pipeline] echo
07:04:31   action when current state is fail/unstable/aborted , previous state is success
[Pipeline] echo
07:04:31   action always failure
[Pipeline] echo
07:04:32   action similar like always , it is using to cleanup folder or workspace
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // timestamps
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
ERROR: script returned exit code 2
Finished: FAILURE


/*
Previous build is failed, current build success O/P.

So Always , change (changes in state from previous state ), fixed (previous buil failed, current passed), 
all executed
*/

/*
Previous build is success O/P

So always only executed, there no action for change and fixed 
*/

