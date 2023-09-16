import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        int[] a = {10, 5, 8, 9, 6, 2, 5, 8, 6};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 排序，归并排序
     */
    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }

    /**
     * 对 a 从 i 到 j 非递增排序
     */
    public static void sort(int[] a, int i, int j) {
        // 分块排序
        int m = (i + j) / 2;
        if (m - i > 1) {
            sort(a, i, m);
        }
        if (j - m > 1) {
            sort(a, m, j);
        }
        // 合并排序结果
        merge(a, i, m ,j);
    }

    /**
     * 合并
     */
    public static void merge(int[] a, int i, int j, int k) {
        int[] left = Arrays.copyOfRange(a, i, j), right = Arrays.copyOfRange(a, j, k);
        int l = 0, m = 0;
//        System.out.println("merge " + i + " " + j + " " + k);
        for (int n = 0; n < k - i; n++) {
            if (l < left.length && m < right.length) {
                if (left[l] < right[m]) {
                    a[i + n] = left[l++];
                } else {
                    a[i + n] = right[m++];
                }
            } else if (l >= left.length && m < right.length) {
                a[i + n] = right[m++];
            } else {
                a[i + n] = left[l++];
            }
        }
    }
}
