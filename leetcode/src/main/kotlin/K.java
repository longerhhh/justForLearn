import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K {
    public static void main(String[] args) {
        queue(4);
    }

    /**
     * 首先使用一个数组来保存各个皇后所放的列，数组长度为 n+1 ，从第一个位置开始作为皇后所在的列
     *
     * @param n
     */
    public static void queue(int n) {
        // 每个皇后放在了这一行中的第几个位置
        int[] columnNumber = new int[n + 1];
        // 要放的皇后是第几个, 找到几个可行解
        int index = 1, answerNumber = 0;
        List<int[]> list = new ArrayList<>();
        list.add(new int[5]);
        list.add(new int[10]);
        while (index > 0) {
            columnNumber[index]++;
            // 皇后的位置不超过这一行的边界 并且 这个位置放置皇后不能满足条件，循环查找下一个位置
            while (columnNumber[index] <= n && !canPlace(columnNumber, index)) {
                columnNumber[index]++;
            }
            // 上面的循环是因为放成功才退出的
            if (columnNumber[index] <= n) {
                // 最后一个位置也放上皇后了
                if (index == n) {
                    answerNumber++;
                    System.out.println(Arrays.toString(columnNumber));
                    for (int i = 1; i < n; i++) {
                        columnNumber[index]++;
                    }
                } else { // 继续寻找下一个皇后的位置
                    index++;
                    columnNumber[index] = 0;
                }
            } else {
                // 当前位置无法放置皇后回退至上一个位置
                index --;
            }
        }
    }

    /**
     * 如果有皇后所放的列与当前皇后准备放的列相同，那么说明其同列，无法放在这里,
     * 如果有皇后所放的列与当前皇后所放的列的差值相同 并且 其所在行与准备防止的皇后所在行的差值相同，
     * 那么说明两个皇后在同一条斜线上，也不满足放的条件，无法放
     *
     * 整个循环没有找到满足以上两种条件的皇后则这个位置可以放，成功
     *
     * @param columnNumber 存储的是每个皇后所放的列
     * @param index 当前皇后准备放的列
     * @return
     */
    private static boolean canPlace(int[] columnNumber, int index) {
        for (int i = 0; i < index; i++) {
            if (columnNumber[i] == columnNumber[index]
                    || Math.abs(columnNumber[index] - columnNumber[i]) == index - i) {
                return false;
            }
        }
        return true;
    }
}
