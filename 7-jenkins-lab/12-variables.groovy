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

----------------------------------------------------------------------------------------

10262021

Scope of the variables: priority order first(script), second(stage), third(global or root)

If you defined the same variable in global, stage, it will pick up the stage 

// global level 
pipeline {
    agent any 
    environment {
        MY_LEVEL = "global-level" // global level variable
    }
    stages {
        stage('user') {
            environment {
               MY_LEVEL = "stage-level" // stage level variable
            }
            steps {
                echo "user defined is $MY_LEVEL variable"
            }
        }
    }
}

O/P:

user defined is stage-level variable

----------------------------------------------------------------------------------------

Predefined Vs User defined values:

If you defined different values in variable, we can call above stage variable by ${env.variablename}

// global level 
pipeline {
    agent any 
    environment {
        MY_LEVEL = "global-level" // global level variable
    }
    stages {
        stage('user') {
            environment {
               MY_LEVEL = "stage-level" // stage level variable
            }
            steps {
                scirpt {
                    MY_LEVEL = "script-level" // script level variable
                }
                    echo " user defined is $MY_LEVEL & previous variable is ${env.MY_LEVEL} "
            }   // end of steps 
        }   // end of stage 
    }   // end of stage
}   // end of pipeline 

O/P:
user defined is script-level & previous variable is stage-level 

----------------------------------------------------------------------------------------

Eventhough it pre-defined variable if we change for custom, priority for user defined 

// global level 
pipeline {
    agent any 
    environment {
        BUILD_NUMBER = "v1.0.0" // global level variable
    }
    stages {
        stage('user') {
            environment {
               MY_LEVEL = "stage-level" // stage level variable
            }
            steps {
                /*
                scirpt {
                    MY_LEVEL = "script-level" // script level variable
                }
                */
                echo "user pre-defined variable is $BUILD_NUMBER"
            }   // end of steps 
        }   // end of stage 
    }   // end of stage
}   // end of pipeline

user pre-defined variable is v1.0.0

----------------------------------------------------------------------------------------

Difference between Single and Double Quotes:

Singel: '' (string)
Double: "" (variable)

----------------------------------------------------------------------------------------

Concatenation:

// global level 
pipeline {
    agent any 
    environment {
        //BUILD_NUMBER = "v1.0.0" // global level variable
        first_name = "xyz"
        last_name = "rzs"
    }
    stages {
        stage('concatenate') {
            steps {
                scirpt {    // error throws
                    Full_Name = first_name + last_name
                }
                echo "Concatenate the string $Full_Name"
            }   // end of steps 
        }   // end of stage 
    }   // end of stage
}   // end of pipeline

O/P:
xyzrzs

----------------------------------------------------------------------------------------

Parameters:

Syntax:

$VARIABLENAME and params, VARIABLENAME is same 

pipeline {
    agent any 
    parameters {
        string(name: 'DEPLOY_ENV', defaultValue: 'staging', description: '')
        text(name: 'DEPLOY_TEXT', defaultValue: 'ONE\nTWO\nTHREE\n', description: '')
        booleanParam(name: 'TOGGLE', defaultValue: 'true', description: 'Toggle this value')
        choice(name: 'CHOICE', defaultValue: '['ONE','TWO','THREE']', description: 'Pick ur choices') 
        file(name: 'FILE', description: 'Somes files to upload') 
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'A secret password') 
    }
    stages {
        stage('string') {
            steps {
                echo "string $DEPLOY_ENV"
                 }   // end of steps 
            }   // end of stage 
        stage('text') {
            steps {
                echo "string $DEPLOY_TEXT"
                 }   // end of steps 
            }   // end of stage 
        stage('booleanParam') {
            steps {
                script {
                    if(TOGGLE){
                        echo "now execute, boolean is true "
                    }else{
                        echo "don't execute, boolean is false "
                    }
                }
        stage('choice') {
            steps {
                scirpt{
                    if(DEPLOY_ENV=='staging'){
                        echo "choice $CHOICE"
                    }
                }
            }
        }   
        stage('file') {
            steps {
                echo "$FILE"
                }
            steps {
                echo "password $PASSWORD"
            }
        }
      }   
    }   
  }   // end of stages
}   // end of pipeline 

