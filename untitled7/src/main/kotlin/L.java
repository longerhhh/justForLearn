import java.util.Arrays;

public class L {
    public static void main(String[] args) {
        queue(4);
    }

    private static void queue(int n) {
        int[] columnNum = new int[n + 1];
        int index = 1;
        while (index > 0) {
            columnNum[index]++;
            while (columnNum[index] < n && !place(columnNum, index)) {
                columnNum[index]++;
            }
            if (columnNum[index] <= n) {
                if (index == n) {
                    System.out.println(Arrays.toString(columnNum));
                    // 做下一步的准备
                } else {
                    index++;
                    columnNum[index] = 0;
                }
            } else {
                index--;
            }
        }
    }

    static boolean place(int[] columnNum, int index) {
//        System.out.println("place " + Arrays.toString(columnNum) + " " + index);
        for (int i = 1; i < index; i++) {
            if (columnNum[i] == columnNum[index] ||
                    Math.abs(columnNum[index] - columnNum[i]) == Math.abs(index - i)) {
                return false;
            }
        }
        return true;
    }
}
