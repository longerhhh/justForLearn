package org.example.entity

class Context(private val name: String, private val description: String) {
    override fun toString(): String {
        return "Context{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}