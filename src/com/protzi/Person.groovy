#!/usr/bin/env groovy
package com.protzi

class Person {
   String name
   Integer age

   Person(name, age) {
     this.name = name
     this.age = age
   }

  def sayHello() {
    echo "Hello, my name is ${this.name}"
  }
}