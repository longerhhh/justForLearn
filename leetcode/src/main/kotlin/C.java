import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 最长子序列

 1. 找出空位
 2. 计算左右连续为1的人数和
 3. 找出最大值的位置
 */
public class C {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int[] f = new int[10_0000];
        int n = 0;
        while (in.hasNext()) {
            f[n++] = in.nextInt();
        }
        in.close();
        // 找出空位
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (f[i] == 0) {
                empty.add(i);
            }
        }
        // 计算左右连续为1的人数和
        int[] count = new int[empty.size()];
        for (int i = 0; i < empty.size(); i++) {
            int c = 0;
            Integer item = empty.get(i);
            // 后面的人位和
            if (item < n-1) {
                for (int j = item + 1; j < n; j++) {
                    if (f[j] == 1) {
                        c++;
                    } else {
                        break;
                    }
                }
            }
            // 前面的人位和
            if (item > 0) {
                for (int j = item - 1; j > 0; j--) {
                    if (f[j] == 1) {
                        c++;
                    } else {
                        break;
                    }
                }
            }
            count[i] = c;
        }
        // 找出最大值的位置
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
