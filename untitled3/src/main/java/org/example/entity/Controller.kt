package org.example.entity

import javax.inject.Inject

class Controller @Inject constructor(private val context: Context) {
    override fun toString(): String {
        return "Controller{" +
                "context=" + context +
                '}'
    }
}