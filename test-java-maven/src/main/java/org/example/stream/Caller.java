package org.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Caller {
    public static void callStream(int size) {
        operation(generateXBeans(size).stream());
    }

    public static void callParallelStream(int size) {
        operation(generateXBeans(size).parallelStream());
    }

    private static void operation(Stream<XBean> stream) {
        stream.collect(Collectors.groupingBy(
                               XBean::getId, Collectors.groupingBy(
                                       XBean::getName, Collectors.groupingBy(
                                               XBean::getAge, Collectors.mapping(XBean::getContent, Collectors.toList()))
                               )
                       )
        );
    }

    public static List<XBean> generateXBeans(int size) {
        Random random = new Random();
        ArrayList<XBean> xBeans = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            xBeans.add(XBean.builder().setAge(generateRandomString()).setId(random.nextInt()).setName(generateRandomString()).setContent(generateRandomString()).build());
        }
        return xBeans;
    }

    public static String generateRandomString() {
        int length = new Random().nextInt(91) + 10;  // 生成10到100的随机数
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char ch = (char) ('a' + new Random().nextInt(26));  // 生成随机小写字母
            sb.append(ch);
        }
        return sb.toString();
    }
}
