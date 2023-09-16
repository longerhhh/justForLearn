import java.util.ArrayList;
import java.util.List;

public class I {
    public static void main(String[] args) {
    }

    /**
     * 0-1 背包问题搜索所有的解空间
     *
     * 使用一个数组存放所有物品是否放成功，
     * 从index=1开始遍历，如果背包还有容量可以放，
     * 放进去，直到背包容量为0或者所有的物品都搜索了一遍
     * 这样就是一个可行解
     *
     * 回溯，假设不放着个物品
     */
    public static void search(int[] weights, int[] values, int n, int w) {
        List<Integer> list = new ArrayList<Integer>();
        int max = 0;

    }
}
