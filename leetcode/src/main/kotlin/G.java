public class G {
    public static void main(String[] args) {
        System.out.println(maxSubSum(new int[]{5,9,-5,0,6}, 0, 5));
    }

    /**
     * 最大字段和
     */
    public static int maxSubSum(int[] a, int s, int e) {
        int max = a[0];
        if (e - s > 1) {
            int m = (s + e) / 2;
            int l = maxSubSum(a, s, m);
            int r = maxSubSum(a, m, e);
            if (max < l) {
                max = l;
            }
            if (max < r) {
                max = r;
            }
            // 包含中间项目的子段和
            int am = a[m];
            for (int i = m + 1; i < a.length; i++) {
                if (a[i] >= 0) {
                    am += a[i];
                } else {
                    break;
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                if (a[i] >= 0) {
                    am += a[i];
                } else {
                    break;
                }
            }
            if (max < am) {
                max = am;
            }
            return max;
        } else {
            return a[s];
        }
    }
}
