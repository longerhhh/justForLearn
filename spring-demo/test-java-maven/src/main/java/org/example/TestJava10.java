package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * java 10 新增局部变量类型推断
 * 例如 var x = 10
 */
public class TestJava10 {
    public static void main(String[] args) {
        var x = 10;
        var y = 10.0;
        var z = 10f;
        // 不支持一行定义多个变量 例如：
        // var x=1, y=1;
        // 不支持定义null，无法推断出类型 例如：
        // var x=null;
        var a = new ArrayList<>();
        System.out.println("a.getClass() = " + a.getClass());
        var b = new HashMap<>();
        System.out.println("b.getClass() = " + b.getClass());
        var c = new BigDecimal("1");
        System.out.println("c.getClass() = " + c.getClass());
    }
}

