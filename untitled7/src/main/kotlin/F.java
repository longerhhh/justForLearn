import java.lang.reflect.Array;
import java.util.Arrays;

public class F {
    public static void main(String[] args) {
        int[] a = {5, 8, 0, 6, 9, 3, 45, 8, 3, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序
     */
    private static void mergeSort(int[] a) {
        sort(a, 0, a.length);
    }

    private static void merge(int[] a, int s, int m, int e) {
        int[] l = Arrays.copyOfRange(a, s, m), r = Arrays.copyOfRange(a, m, e);
        int n = e - s, i = 0, j = 0;
        if (l.length > 0 && r.length > 0) {
            while (s < e) {
                System.out.println("merge " + s + " " + m + " " + e + " " + i + " " + j);
                if (i >= l.length) {
                    a[s++] = r[j++];
                } else if (j >= r.length) {
                    a[s++] = l[i++];
                } else if (l[i] <= r[j]) {
                    a[s++] = l[i++];
                } else {
                    a[s++] = r[j++];
                }
            }
        }
    }

    private static void sort(int[] a, int i, int j) {
        int m = (i + j) / 2;
        System.out.println("sort " + i + " " + m + " " + j);
        if (m - i > 1) {
            sort(a, i, m);
        }
        if (j - m > 1) {
            sort(a, m, j);
        }
        merge(a, i, m, j);
    }
}
