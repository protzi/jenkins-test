pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                checkout scm
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
}
