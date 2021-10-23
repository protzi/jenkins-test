def PR_TITLE_REGEXP = /^(\[((.*)KLIC-(\d*)|Hotfix)\] (.{5,})|(Pre-release|Release)(.*))$/

def checkPullRequestTitle(title) {
    echo "Checking PR title: ${title}"
    def matcher = title =~ PR_TITLE_REGEXP
    if (matcher && matcher[0][1]) {
        echo 'PR title is valid'
    } else {
        error('PR title is not valid')
    }
}

pipeline {
    environment {
        PROJECT_NAME = 'jenkins-test'
    }
    agent {
        docker { dockerfile true }
    }
    stages {
        stage('PR title check') {
            steps {
                checkPullRequestTitle(env.CHANGE_TITLE)
            }
        }
        stage('Build') {
            steps {
                echo 'building...'
                echo 'ls'
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
