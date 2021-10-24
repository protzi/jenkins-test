
pipeline {
    agent any
    environment {
        projectName = 'jenkins-test'
        projectImage = ''
    }
    
    stages {
        stage('Build') {
            steps {
                script {
                    projectImage = docker.build("${projectName}:latest")   
                }
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
