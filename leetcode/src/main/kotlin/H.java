import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class H {
    public static void main(String[] args) {
//        pack(new int[]{30, 10, 20, 50, 40}, new int[]{65, 20, 30, 60, 40}, 100, 5);
        pack(new int[]{3, 4, 7, 8, 9}, new int[]{4, 5, 10, 11, 13}, 17, 5);
    }

    /**
     * 0-1 背包
     */
    public static void pack(int[] w, int[] v, int max, int n) {
        int[][] a = new int[n + 1][max + 1];
        for (int i = 0; i < a.length; i++) {
            a[i][0] = 0;
        }
        Arrays.fill(a[0], 0);
        for (int i = 1; i <= n; i++) {
            int t = i;
            for (int j = 1; j <= max; j++) {
                if (j >= w[i - 1]) {
                    if ((t = v[i - 1] + a[i-1][j - w[i - 1]]) > a[i - 1][j]) {
                        a[i][j] = t;
                    } else {
                        a[i][j] = a[i - 1][j];
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        int m = max;
        for (int i = n; i > 0; i--) {
            // 没放
            if (a[i][m] == a[i - 1][m]) {
                System.out.println("not put " + i + ";");
            } else {
                list.add(i);
                m -= w[i - 1];
                System.out.println("put " + i + ";");
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
}
