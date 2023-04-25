import java.util.Scanner;

/**
 n: h, w

 T n
 t w (*n)

 1. 计算单位工作时长对应的工作报酬，逆序排序
 2. 尽量做单位工作报酬多的工作，贪心算法
 3. 到后面没法完全做进行回溯
 */

public class B {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int n = in.nextInt();
        int[] t = new int[n], w = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        in.close();
        // 计算单位工作时长对应的工作报酬
        float[] wt = new float[n];
        for (int i = 0; i < n; i++) {
            wt[i] = w[i] / (float) t[i];
        }
        // 逆序排序
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (wt[i] < wt[j]) {
                    float temp = wt[j];
                    wt[j] = wt[i];
                    wt[i] = temp;

                    int t1 = w[i];
                    w[i] = w[j];
                    w[j] = t1;

                    t1 = t[i];
                    t[i] = t[j];
                    t[j] = t1;
                }
            }
        }
        // 尽量做单位工作报酬多的工作
        int cw = 0;
        int ct = 0;
        int fw = 0;
        int ft = 0;
        int maxW = 0;
        int count = 0;
        boolean[] takeW = new boolean[n]; // 存储是否做某工作
        for (int i = 0; i < n; i++) {
            if (ct + t[i] <= T) {
                cw += w[i];
                ct += t[i];
                takeW[i] = true;
                count ++;
            }
        }
        // 还有工作
        if (count < n) {
            // 找到第一个放弃的工作
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (!takeW[i]) {
                    index = i;
                    break;
                }
            }
            // 价值判断，是否有更好的
            if (bound(w, t, wt, n, T, index, cw, ct) > cw) {
            }
        }
        maxW = cw;
        System.out.println(maxW);
    }

    /**
     * 前index项已经确定后，假设为完成的工作也有对应时间比例的报酬时可以获得的报酬
     */
    private static int bound(int[] w, int[] t, float[] wt, int n, int T, int index, int cw, int ct) {
        for (int i = index; i < n; i++) {
            if (t[i] + ct < T) {
                ct += t[i];
                cw += w[i];
                index ++;
            } else {
                cw += (T - ct) * wt[i];
                return cw;
            }
        }
        return cw;
    }
}
