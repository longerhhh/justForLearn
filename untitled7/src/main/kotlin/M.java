import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M {
    public static void main(String[] args) {

        java.util.List<A1> l = new ArrayList<A1>();
        List<AA1> aa = new ArrayList<AA1>();
//        Comparator.comparingInt()
//        l = aa;
//        System.out.println(r());
//        b();
//        queue(3);
//        all1(3);
//        r();

//        Runtime.getRuntime().exec();
//        new ProcessBuilder().start()
//        Set<int[]> set = new HashSet<>();
//        set.add(new int[]{1, 2, 3});
//        set.add(new int[]{1, 2, 3});
//        System.out.println(set.size());
//        all2(3);
//        all3(3);
//        pkg(new int[]{3,4,7,8,9}, new int[]{4,5,10,11,13}, 17);
//        all4(3);
        x();

        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        integers.stream().anyMatch()
    }

    static void x() {
        int[] a = getArr(3);
        v(new LinkedList<>(), a);
    }

    static void v(LinkedList<Integer> list, int[] arr) {
        if (list.size() == arr.length) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
//            if (list.contains(arr[i])) {
//                continue;
//            }
            if (!place(list, i)) {
                continue;
            }
            list.add(arr[i]);
            v(list, arr);
            list.removeLast();
        }
    }

    static boolean place(List<Integer> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), index) || Math.abs(list.get(i) - index) == Math.abs(index - i)) {
                return false;
            }
        }
        return true;
    }

    public static final void all4(int n) {
        int[] arr = getArr(n);
        LinkedList<Integer> list = new LinkedList<>();
        int[] columnNumber = new int[n + 1];
        int i = 1;
        while (i > 0) {
            columnNumber[i]++;
            while (columnNumber[i] <= n && !L.place(columnNumber, i)) {
                columnNumber[i]++;
            }
            if (columnNumber[i] <= n) {
                if (i == n) {
                    System.out.println("fff");
                    System.out.println(Arrays.toString(Arrays.copyOfRange(columnNumber, 1, n)));
                } else {
                    i++;
                    columnNumber[i] = 0;
                }
            } else {
                i--;
            }
        }
    }

    public static final void all3(int n) {
        int[] arr = getArr(n);
        LinkedList<Integer> list = new LinkedList<>();
        visit(list, arr);
    }

    public static final void visit(LinkedList<Integer> list, int[] arr) {
        if (list.size() == arr.length) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i++);
            visit(list, arr);
            list.removeLast();
        }
    }

    public static final void visit1(LinkedList<Integer> list, int[] arr, int index) {
        if (list.size() == arr.length) {
            System.out.println(Arrays.toString(list.toArray()));
            return;
        }
        list.add(index++);
        visit1(list, arr, index);
        list.removeLast();
        index--;
    }

    public static final void all2(int n) {
        int[] arr = getArr(n);
        int[] columnNumbers = new int[n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int index = 1;
        while (index > 0) {
            columnNumbers[index]++;
            while (columnNumbers[index] < n && list.contains(columnNumbers[index])) {
                columnNumbers[index]++;
            }
            System.out.println("index=" + index + " columnNumber=" + columnNumbers[index]);
            if (columnNumbers[index] < n) {
                list.add(arr[columnNumbers[index]]);
                if (index == n) {
                    System.out.println(Arrays.toString(list.toArray()));
                    list.removeLast();
                } else {
                    index++;
                    columnNumbers[index] = 0;
                }
            } else {
                index--;
            }
        }
    }

    public static final void pkg(int[] weights, int[] values, int w) {
        int[][] c = new int[weights.length + 1][w + 1];
        c[0] = new int[w + 1];
        for (int i = 1; i < weights.length + 1; i++) {
            c[i][0] = 0;
            for (int j = 1; j < w + 1; j++) {
                if (weights[i - 1] <= j) {
                    int t = values[i - 1] + c[i - 1][j - weights[i - 1]];
                    if (t > c[i - 1][j]) {
                        c[i][j] = t;
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        System.out.println(0);
    }

    public static final void all1(int n) {
        boolean[] selected = new boolean[n];
        int[] arr = getArr(n);
        backTrace(arr, new LinkedList<>());
    }

    private static int[] getArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static void backTrace(int[] nums, LinkedList<Integer> track) {
        // 相等的时候，说明得到了一个全排列
        if (track.size() == nums.length) {
            System.out.println(Arrays.toString(track.toArray()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果已经存在该元素，就不添加
            if (track.contains(nums[i])) {
                continue;
            }

            // 选择元素
            track.add(nums[i]);
            backTrace(nums, track);
            // 撤销选择
            track.removeLast();
        }
    }

    public static final void all(int n) {
        boolean[] selected = new boolean[n];
        int[] arr = getArr(n);
        int index = 0;
        while (index >= 0) {
            while (arr[index] < n && selected[arr[index]]) {
                arr[index]++;
            }
            if (arr[index] < n) {
                if (index == n - 1) {
                    System.out.println(Arrays.toString(arr));
                    index--;
                } else {
                    index++;
                    arr[index] = 0;
                }
            } else {
                selected[arr[index]] = false;
                index--;
            }
        }
    }

    public static final void queue(int n) {
        int[] columnNumber = new int[n + 1];
        int i = 1;
        while (i > 0) {
            columnNumber[i]++;
            while (columnNumber[i] <= n && !L.place(columnNumber, i)) {
                columnNumber[i]++;
            }
            if (columnNumber[i] <= n) {
                System.out.println("fff");
                if (i == n) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(columnNumber, 1, n)));
                } else {
                    i++;
                    columnNumber[i] = 0;
                }
            } else {
                i--;
            }
        }
    }

    public static final Boolean r() {
        try {
            return true;
        } catch (Exception e) {
            return null;
        } finally {
            return false;
        }
    }

    public static final void a() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map = new HashMap<>();
        map = new LinkedHashMap<>();
    }

    public static final int b() {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(1);
        set.add(9);
        set.add(4);
        set.add(4);
        System.out.println(Arrays.toString(set.toArray()));
        return 0;
    }
}
