node {
    stage('Build') {
        echo 'Hello World in build'
    }
    stage('Test') {
        echo 'Hello World in test'
    }
    stage('Deploy'){
        echo 'Hello World in deploy'
    }
}