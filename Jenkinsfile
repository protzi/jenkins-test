#!groovy

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
                
                PROJECT_IMAGE.inside {
                    stage('Install project dependencies') {
                        installProjectDependencies()
                    }
                    
                    stage('Test project') {
                        testProject()
                    }

                    stage('Build project env') {
                        buildProjectEnvConfig()
                        echo 'ls'
                        echo 'cat .env'
                    }
                    
                    stage('Deployment') {
                        deployProjectToAWSElasticBeanstalk()
                    }
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
