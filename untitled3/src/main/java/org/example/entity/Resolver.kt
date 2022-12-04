package org.example.entity

class Resolver(val context: Context, val controller: Controller) {

    override fun toString(): String {
        return "Resolver{" +
                "context=" + context +
                ", controller=" + controller +
                '}'
    }
}