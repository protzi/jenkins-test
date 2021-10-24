#!groovy

node {
    def PROJECT_NAME = 'jenkins-test'
    def PROJECT_IMAGE = ''

    try {
        if (env.CHANGE_TITLE) {
            echo "checking PR title"
        } else {
            lock(resource: "${PROJECT_NAME}-${env.BRANCH_NAME}-deploy-lock") {
                stage('Checkout') {
                    checkout scm
                }
            }
        }
    }
    catch (exception) {
        echo "I failed, ${exception}"
        currentBuild.result = 'FAILURE'
    }
    finally {
        echo "I am ${currentBuild.result}. One way or another, I have finished"
        deleteDir()
    }
}
