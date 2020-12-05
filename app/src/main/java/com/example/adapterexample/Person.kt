package com.example.adapterexample


class Person(
    val name: String,
    val surName: String
)

object PersonGenerator {
    fun generatePersons() = List(100) {
        Person("name-$it", "surName-$it")
    }
}