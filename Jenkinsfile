#!groovy

node {
    def image = ''
    def name = 'jenkins-test'

    try {
        if (env.CHANGE_TITLE) {
            echo "checking PR title"
        } else {
            echo "build process"
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
