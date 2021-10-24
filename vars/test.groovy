#!/usr/bin/env groovy

def call(String name = 'human') {
    echo "Hello, ${name}."
}

def buildProjectImage(PROJECT_NAME, BRANCH_NAME) {
    def md5Name = (sh (script: 'echo -n "${BRANCH_NAME}" | md5sum | awk \'{print $1}\'', returnStdout: true)).trim()
    return docker.build("${PROJECT_NAME}-${md5Name}-container")
}

def installProjectDependencies() {
    echo 'installing npm modules...'   
}

def testProject() {
    echo 'testing project...'   
}

def buildProjectEnvConfig() {
    // Get config from somewhere... and build .env file
    writeFile file: '.env', text: 'APP_BUILD_ID=1'
}

def getProjectEnvName(BRANCH_NAME) {
    if (BRANCH_NAME == 'master') {
        return 'production'
    }
    if (BRANCH_NAME == 'release-candidate') {
        return 'rc'
    }
    return 'development'
}

def deployProjectToAWSElasticBeanstalk() {
    echo 'deploying to aws beanstalk...'
}