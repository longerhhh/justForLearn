import java.util.Arrays;
import java.util.WeakHashMap;

/**
 * 背包问题
 */
public class C {
    public static void main(String[] args) {
        int[] w = new int[]{30,10,20,50,40};
        float[] v = new float[]{65,20,30,60,40};
        pack1(w,v, 100);
    }

    private static int[] pack(int[] w, int[] v, int W) {
        int[][] a = new int[W+1][v.length+1];
        for (int i = 0; i < v.length + 1; i++) {
            a[0][i] = 0;
        }
        for (int i = 0; i < W; i++) {
            a[i][0] = 0;
        }
        int b = W;
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= w.length; j++) {
                // 可以放
                if (W > w[j-1]) {
                    // 放上更好
                    int putin = w[j-1] + a[W - w[i]][j-1];
                    if (putin > a[i][j-1]) {
                        a[i][j] = putin;
                    } else {
                        a[i][j] = a[i - 1][j];
                    }
                }
            }
        }
        System.out.println("[");
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("]");
        return new int[0];
    }

    // 传入的w，v按单位价值排序
    private static int[] pack1(int[] w, float[] v, int W) {
        float[] vw = new float[w.length];
        for (int i = 0; i < vw.length; i++) {
            vw[i] = v[i]/w[i];
        }
        int n = w.length;
        int cw = 0, weight = 0;
        float cv = 0, profit = -1;
        int index = 0;
        int[] x = new int[w.length], y = new int[w.length];
        while (true) {
            // 贪心放
            while (index < n && cw + w[index] <= W) {
                cv += v[index];
                cw += w[index];
                y[index] = 1; // 放进去
                System.out.println("put index="+index);
                index ++;
            }
            // 能放的都放了
            if (index >= n) {
                weight = cw;
                profit = cv;
                index = n-1;
                // 复制放的结果
                for (int i = 0; i < n; i++) {
                    x[i] = y[i];
                }
                System.out.println("all put");
            } else {
                // 这个没法放不放了
                y[index] = 0;
                System.out.println("not put "+index);
            }
            System.out.println("index = "+index);
            // 按背包问题来放，如果价值小于等于当前最优价值
            float a;
            while ((a = bound(v, w, vw, W, cv, cw, 0)) <= cv) {
                System.out.println("a="+a+",cv="+cv);
                // 没有遍历到最开始，并且当前index的物品是没放的
                while (index != 0 && y[index] != 1) {
                    index --;
                }
                // 遍历到最开始了
                if (index == 0) {
                    return x;
                }
                y[index] = 0;
                cv -= v[index];
                cw -= w[index];
            }
            index++;
        }
    }

    private static float bound(float[] v, int[] w, float[] vw, int W, float cv, int cw, int index) {
        for (int i = index + 1; i < v.length; i++) {
            if (cw + w[i] <= W) {
                cv += v[i];
                cw += w[i];
            } else {
                cv += vw[i] * (W - cw);
                cw = W;
                return cv;
            }
        }
        return cv;
    }


}
