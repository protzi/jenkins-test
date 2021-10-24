
pipeline {
    agent any
    environment {
        PROJECT_NAME = 'jenkins-test'
    }
    
    stages {
        stage('Build') {
            steps {
                sh "docker build -t ${PROJECT_NAME}:latest ."
            }
        }
        stage('Inside steps') {
            steps {
                sh "docker images ls"
                sh "ls"
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
