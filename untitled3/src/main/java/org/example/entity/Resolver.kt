package org.example.entity

import javax.inject.Inject

class Resolver @Inject constructor(private val context: Context, private val controller: Controller) {

    override fun toString(): String {
        return "Resolver{" +
                "context=" + context +
                ", controller=" + controller +
                '}'
    }
}