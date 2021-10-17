pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo 'building...'
            }
        }
        stage('Test') { 
            steps {
                echo 'testing...'
            }
        }
        stage('Deploy') { 
            steps {
                echo 'deploying...'
            }
        }
    }
    post {
        failure {
            echo 'failed'
        }
        success {
            echo 'success'
        }
    }
}
