
pipeline {
    agent any
    
    stages {
        stage('Build') {
            agent { dockerfile true }
            steps {
                sh 'ls'
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
