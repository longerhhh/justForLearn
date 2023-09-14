package com.example.springdemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@SpringBootApplication
class SpringDemoApplication
fun main(args: Array<String>) {
    val applicationContext = runApplication<SpringDemoApplication>(*args)
//    applicationContext.getBean(B::class.java).b()
}

@Component
class A {
    fun a() {
        println('a')
    }
}

@Service
class B @Autowired constructor(private val a: A){
    fun b() {
        print("b:")
        a.a()
    }
}
