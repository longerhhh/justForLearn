import java.util.Arrays;

public class C {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{-1, -1};
        boolean isStart = false;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i] && !isStart) {
                range[0] = i;
                range[1] = i;
                isStart = true;
            } else if (nums[i] == target) {
                range[1] = i;
            } else if (nums[i] > target) {
                break;
            }
        }
        return range;
    }
}
