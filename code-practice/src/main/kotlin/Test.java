public class Test {
    public static void main(String[] args) {
    }

    /**
     * 归并排序， p\q\r是下标，p<=q<r
     * @param a
     * @param p
     * @param r
     */
    private static void mergeSort(int[] a, int p, int r) {
        int q=0;
        if (p < r) {
            q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + r, r);
            merge(a,p,q,r);
        }
    }

    /**
     *
     * @param a
     * @param p
     * @param q
     * @param r
     */
    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1, n2 = r - q, i = 0, j = 0, k = 0;
        // 记录左右数组
        int[] left = new int[50], right = new int[50];
        for (i = 0; i < n1; i++) {
            left[i] = a[p + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = a[q + j + i];
        }
        left[n1] = Integer.MAX_VALUE;
        right[n2]=Integer.MAX_VALUE;
        i = 0;
        j = 0;
        // 将左右数组按顺序放入主数组
        for (k = p; k < r+1; k++) {
            if (left[i] < right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
        }
    }
}
