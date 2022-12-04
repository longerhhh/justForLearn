package org.example.entity

class Context(val name: String, val description: String) {

    override fun toString(): String {
        return "Context{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}'
    }
}