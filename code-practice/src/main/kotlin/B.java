import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class B {
    public static void main(String[] args) {
        printAll(new int[]{1, 2, 3});
    }

    /**
     * 输出全排列
     * <p>
     * 递归去遍历，假设有n个a数组，
     * 新建一个数组，数组中没有包含这个可以继续遍历，否则查看下一个节点，
     * <p>
     * 遍历到n个的时候创建新的数组，继续回溯到上一个节点
     *
     * @param a
     */
    private static void printAll(int[] a) {
        int n = a.length;
        List<int[]> result = new ArrayList<>();
        // 临时存储当前遍历结果
        int[] r = new int[n];
        // 记录上一次行坐标遍历到那里了
        int[] record = new int[n];
        for (int j = 0, i = 0; j > 0; ) {
            // 所在列没有超过n并且现有数组中不包含这个元素可以插入
            if (i < n && !contains(r, a[i])) {
                r[j] = a[i];
                record[j] = i;
                i = 0;
                j++;
            } else {
                i++;
            }
            // 遍历到n个的时候创建新的数组，继续回溯到上一个节点
            if (j >= n) {
                result.add(Arrays.copyOf(r, n));
                System.out.println(Arrays.toString(r));
                // 回退之后上一次的i就丢失了
                j--;
                i = record[j];
            }
        }
        // 输出
        System.out.print("[");
        for (int j = 0; j < result.size(); j++) {
            int[] ints = result.get(j);
            System.out.print(Arrays.toString(ints));
            if (j < ints.length) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    private static boolean contains(int[] a, int i) {
        for (int k : a) {
            if (k == i) {
                return true;
            }
        }
        return false;
    }
}
/*
1 2 3
1 2 3
1 2 3
 */
