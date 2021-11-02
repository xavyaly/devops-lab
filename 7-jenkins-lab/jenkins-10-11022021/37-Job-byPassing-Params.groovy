/*
Trigger other job with parameters
Already job is created, it contains parameter data to build job
Running job pipeline script
*/

/*
Build Trigger:
    Trigger jobs from pipeline
    How to trigger second build, even first build fails
    How to change build result
    Call a job by passing parameters
*/
/*Trigger other jobs with parameters*/
/*Name: Triggered-By-Pipeline-Job*/
pipeline {
    agent any
    parameters {
        choice(
            name: 'Nodes',
            choices:"Linux\nMac",
            description: "Choose Node!")
        choice(
            name: 'Versions',
            choices:"3.4\n4.4",
            description: "Build for which version?" )
        string(
            name: 'Path',
            defaultValue:"/home/pencillr/builds/",
            description: "Where to put the build!")
        }   
        stages {
            stage("build") {
                steps {
                    script {
                        echo "$Nodes"
                        echo "Versions"
                        echo "Path"
                    }
                }
            }
        }
    
}

/*Next Create this Job*/
/*Call a job by passing parameters*/
pipeline {
    agent any
    stages {
        stage("build") {
            steps {
                script {
                    build(job: "Triggered-By-Pipeline-Job",
                    parameters:
                    [string(name: 'Nodes', value: "Linux"),
                    string(name: 'Versions', value: "3.4"),
                    string(name: 'Path', value: "/home/pencillr/builds/}")])
                }
            }
        }
    }
}
