#!groovy

def buildProjectImage(PROJECT_NAME, BRANCH_NAME) {
    def md5Name = (sh (script: 'echo -n "${BRANCH_NAME}" | md5sum | awk \'{print $1}\'', returnStdout: true)).trim()
    return docker.build("${PROJECT_NAME}-${md5Name}-container")   
}

node {
    def PROJECT_NAME = 'jenkins-test'
    def PROJECT_IMAGE = ''
    // Temp hardcode
    env.BRANCH_NAME = 'master'

    try {
        if (env.CHANGE_TITLE) {
            echo "checking PR title"
        } else {
            lock(resource: "${PROJECT_NAME}-${env.BRANCH_NAME}-deploy-lock") {
                stage('Checkout') {
                    sh 'printenv'
                    checkout scm
                }
                
                stage('Build project image') {
                    PROJECT_IMAGE = buildProjectImage(PROJECT_NAME, env.BRANCH_NAME)
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
