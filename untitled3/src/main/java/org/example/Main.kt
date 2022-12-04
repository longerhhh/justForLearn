package org.example

import org.example.entity.Context
import org.example.entity.OverlayPlugin

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        OverlayPlugin().onCreate(Context("name", "description"))
    }
}