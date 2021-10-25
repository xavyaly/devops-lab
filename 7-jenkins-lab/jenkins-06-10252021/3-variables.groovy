/*
pre defined variables
user defined variables 

<variable_name> = <variable_value>
*/

//pre defined variables

pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo "pre defined variable $BUILD_NUMBER $WORKSPACE"
            }
        }
    }
}

// user defined variables
pipeline {
    agent any 
    environment {
        MY_CREDENTIALS = "dev-credentials"
    }
    stages {
        stage('user') {
            steps {
                echo "pre defined variable $MY_CREDENTIALS"
            }
        }
    }
}

--------------------------------------------------------------------------------

// user defined variables
/*
global level 
stage level 
script level 
*/

// global level 
pipeline {
    agent any 
    environment {
        MY_CREDENTIALS = "dev-credentials" // global level 
    }
    stages {
        stage('user') {
            steps {
                echo "pre defined variable $MY_CREDENTIALS"
            }
        }
    }
}

// stage level 
pipeline {
    agent any 
    stages {
        stage('user') {
            environment {
            MY_CREDENTIALS = "dev-credentials" // stage level 
            }
          steps {
            echo "pre defined variable $MY_CREDENTIALS"
            }
        }
    }
}

// script level 
pipeline {
    agent any 
    stages {
        stage('user') {
            steps {
                scirpt {
                    MY_CREDENTIALS = "dev-credentials" // script level 
                }
            echo "pre defined variable $MY_CREDENTIALS"
            }
        }
    }
}
OR
// script level 
pipeline {
    agent any 
    stages {
        stage('user') {
            steps {
                scirpt {
                    MY_CREDENTIALS = "dev-credentials" // script level 
                    echo "pre defined variable $MY_CREDENTIALS"
                }
            }
        }
    }
}