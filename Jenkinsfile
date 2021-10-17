pipeline {
    agent any 
    stages {
        stage('Build') {
            steps {
                echo 'building...'
                sh 'docker --version'
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
        always {
            cleanWs()
        }
    }
}
