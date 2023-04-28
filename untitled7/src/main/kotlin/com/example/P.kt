package com.example

class P {
    fun isMatch(s: String, p: String): Boolean {
        if (p.contains('.') || p.contains('*')) {
            var i = 0
            var j = 0
        } else {
            return s == p
        }
    }
}
