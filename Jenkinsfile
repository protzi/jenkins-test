#!groovy
@Library('project-test-library')_

import com.protzi.Person

node {
    test('Oleg')

    stage('Create person') {
        def oleg = new Person('Oleg', 21)
        oleg.sayHello()
    }
}
