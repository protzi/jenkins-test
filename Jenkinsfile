
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'checkout success'
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
