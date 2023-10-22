package com.example.springdemo.pojo

import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

/**
 * @param id : 物流单号
 * @param deliverCompany : 物流公司
 * @param status ： 物流状态
 */
@PropertySource("classpath:/jdbc.properties")

data class Courier(
    val id: Int,
    val deliverCompany: String,
    val status: String,
)