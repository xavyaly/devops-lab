Option Set:
    Stage Level 
    Pipe Level

Retry: before failing the job, will run the job again to specified times

buildDiscarder:
    numbers: options {buildDiscarder(logRotator(numToKeepStr: '5'))}
    days: options {buildDiscarder(logRotator(daysToKeepStr: '7'))}

disableConcurrentBuilds:
    used to disable concurrent builds
    OR
    if execute the build if it takes time to complete again parallely, 
    we trigger before complete the previous build, again build get start to execute,
    due to this job will get conflicts with nodes 


