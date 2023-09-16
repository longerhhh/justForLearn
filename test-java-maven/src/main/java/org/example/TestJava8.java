package org.example;

import java.time.LocalDateTime;
import java.util.Base64;

public class TestJava8 {
    public static void main(String[] args) {
        // lambda 表达式
        // 方法引用
        // 接口中的默认方法
        // Stream Api
        // Optional 类
        // DateTime Api == LocalDateTime
        LocalDateTime now = LocalDateTime.now();
        // Nashorn javascript引擎支持
        // Base64
        // 三种类型
        Base64.getEncoder(); // 基本类型，输出A-Za-z0-9+
        Base64.getUrlEncoder(); // URL 类型，输出URL和文件
        Base64.getMimeEncoder(); // MIME 类型，每行不超过76字符，用\r\n分割，最后一行没有\r\n
        Base64.getDecoder().decode("");
        Base64.getEncoder().encode(new byte[2]);
        switch (1) {
            case 0 -> {
                System.out.println(0);

            }
            case 1 -> {
                System.out.println(1);
            }
        }
    }
}
