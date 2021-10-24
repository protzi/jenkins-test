
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
                sh "docker exec -it ${PROJECT_NAME}:latest sh"
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
