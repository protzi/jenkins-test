
pipeline {
    agent any
    environment {
        PROJECT_NAME = 'jenkins-test'
    }
    
    stages {
        stage('Build') {
            agent dockerfile {
                additionalBuildArgs  '--tag $PROJECT_NAME:$BRANCH_NAME'
            }
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
