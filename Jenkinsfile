#!groovy
@Library('project-test-library')_

import com.protzi.Person

node {

    stage('Global test') {
        test('Oleg')
    }

    stage('Create person') {
        def oleg = new Person('Oleg', 21)
        echo oleg.sayHello()
    }
}
