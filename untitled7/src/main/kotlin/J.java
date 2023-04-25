import java.util.Arrays;
import java.util.Stack;

public class J {
    public static void main(String[] args) {
        maxSeq("ABCBDAB".toCharArray(), "BDCABA".toCharArray());
    }

    public static void maxSeq(char[] c, char[] d) {
        byte[][] a = new byte[c.length + 1][d.length + 1];
        byte[][] b = new byte[c.length + 1][d.length + 1];
        Arrays.fill(a[0], (byte) 0);
        for (int i = 1; i <= c.length; i++) {
            for (int j = 1; j <= d.length; j++) {
                if (c[i - 1] == d[j - 1]) {
                    a[i][j] = (byte) (a[i - 1][j - 1] + 1);
                    b[i][j] = 0;
                } else if (a[i - 1][j] >= a[i][j - 1]) {
                    a[i][j] = (byte) (a[i - 1][j]);
                    b[i][j] = 1;
                } else {
                    a[i][j] = (byte) (a[i][j - 1]);
                    b[i][j] = 2;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = c.length, j = d.length; i > 0 && j > 0; ) {
            if (b[i][j] == 0) {
                stack.add(c[i - 1]);
                i--;
                j--;
            } else if (b[i][j] == 1) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(stack);
    }
}
