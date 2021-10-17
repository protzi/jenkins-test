pipeline {
    agent {
        docker { image 'node:14-alpine' }
    }
    stages {
        stage('Build') {
            steps {
                echo 'building...'
            }
        }
        stage('Test') { 
            steps {
                sh 'node --version'
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
