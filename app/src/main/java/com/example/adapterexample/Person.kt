package com.example.adapterexample


data class Person(
    val id: Long,
    val name: String,
    val surName: String
)

object PersonGenerator {
    fun generatePersons() = List(100) {
        Person(it.toLong(), "name-$it", "surName-$it")
    }
}