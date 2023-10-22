package com.example.springdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class TestController {
    @GetMapping("/gg")
    fun test() = "gg"
}