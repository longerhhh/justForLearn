package com.example;

public class N {
    public static void main(String[] args) {
        System.out.println(new N().myAtoi("words and 987"));
        System.out.println(new N().myAtoi("987 words and"));
        System.out.println(new N().myAtoi("00000-42a1234"));
        System.out.println(new N().myAtoi("42"));
        System.out.println(new N().myAtoi("-42"));
        System.out.println(new N().myAtoi("+-42"));
    }

    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean hasFlag = false;
        for (char c : chars) {
            if ((!hasFlag || sb.isEmpty()) && c == ' ') {
                System.out.println("-");
            } else if (sb.isEmpty() && !hasFlag && c == '-') {
                hasFlag = true;
                sb.append(c);
                System.out.println("--");
            } else if (sb.isEmpty() && !hasFlag && c == '+') {
                System.out.println("---");
                hasFlag = true;
            } else if (c >= '0' && c <= '9') {
                sb.append(c);
                System.out.println("----");
            } else {
                System.out.println("-----");
                break;
            }
        }
        if (sb.isEmpty()) {
            return 0;
        }
        s = sb.toString();
        boolean isNeg = s.charAt(0) == '-';
        chars = (isNeg ? s.substring(1) : s).toCharArray();
        int r = 0, t = 0;
        for (int i = 0; i < chars.length; i++) {
            t = r * 10 + (chars[i] - '0') * (isNeg ? -1 : 1);
            if (r >= 0 && t > r || r <= 0 && t < r) {
                r = t;
            } else if (isNeg) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return r;
    }

    public int reverse(int x) {
        int r = 0, max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (r > max || r < min) return 0;
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }

    public int reverse2(int x) {
        String s = String.valueOf(x);
        boolean isNegative = s.charAt(0) == '-';
        if (isNegative) {
            s = s.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        s = isNegative ? "-" + sb : sb.toString();
        long l = Long.parseLong(s);
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        } else return (int) l;
    }

    public int reverse1(int x) {
        String s = String.valueOf(x);
        boolean isNegative = s.charAt(0) == '-';
        long l = Long.parseLong((isNegative ? "-" : "") + new StringBuilder(isNegative ? s.substring(1) : s).reverse());
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        } else return (int) l;
    }
}
