#!groovy
@Library('project-test-library')

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

                    stage('Build project env') {
                        buildProjectEnvConfig()
                        sh 'cat .env'
                    }

                    stage('Test project') {
                        testProject()
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
