import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class D {
//    public static void main(String[] args) {
//        // 输入
//        Scanner in = new Scanner(System.in);
//        // 2 ~ 50, 0~100
//        int n = in.nextInt(), d = in.nextInt();
//        // 0~100
//        byte[] f = new byte[n];
//        for (int i = 0; i < n; i++) {
//            f[i] = in.nextByte();
//        }
//        in.close();
//        pair(n, d, f);
//    }
//
//    /**
//     * 使用贪心做邻近匹配
//     */
//    public static void pair(int n, int d, byte[] f) {
//        // 排序，从小到大
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (f[i] > f[j]) {
//                    byte t = f[i];
//                    f[i] = f[j];
//                    f[j] = t;
//                }
//            }
//        }
//        int sumD = -1; // 实力和
//        boolean isNan = true;
//        int i = 0;
//        List<Byte> cannotPair = new ArrayList<Byte>();
//        while (i < n) {
//            if (i < n - 1) {
//                if (f[i+1]-f[i]<=d) {
//                    sumD = 0;
//                    isNan = false;
//                } else {
//                    if (i - 1 > 0 && f[i] - f[i - 1] >= d) {
//                        cannotPair.add((byte) i);
//                    }
//                }
//                i ++;
//            } else {
//                break;
//            }
//        }
//        if (!isNan) {
//            List<Pair> pairs = new ArrayList<Pair>(); // 保存匹配好的组
//            // 根据不能匹配的分组
//            List<List<Byte>> groups = new ArrayList<>();
//            List<Byte> tempList = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                if (!cannotPair.contains(j)) {
//                    tempList.add((byte) j);
//                } else {
//                    groups.add(tempList);
//                    tempList = new ArrayList<>();
//                }
//            }
//            groups.add(tempList);
//            List<Byte>[] noPairs = new ArrayList<>[groups.size()]; // 分组后每个组对应的没有匹配的组
//            // 邻近匹配，如果出现中间一个没法匹配，但是可以与前面的匹配，那么去调整
//            for (int i1 = 0; i1 < groups.size(); i1++) {
//                List<Byte> l = groups.get(i1);
//                List<Byte> temp = new ArrayList<Byte>();
//                for (int i2 = 0; i2 < l.size(); i2++) {
//                    if (i2 < l.size()-1) {
//                        System.out.println(l.get(i2) + "," + f[l.get(i2)]);
//                        int t = f[l.get(i2+1)]-f[l.get(i2)];
//                        if (t < d) {
//                            sumD += t;
//                            i2 ++;
//                        } else {
//                            temp.add(l.get(i2));
//                        }
//                    }
//                }
//                noPairs[i1] = temp;
//            }
//        }
//        System.out.println(sumD);
//    }
//
//    public static void calcu(int n, int d, byte[] f) {
//        // 排序，从小到大
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (f[i] > f[j]) {
//                    byte t = f[i];
//                    f[i] = f[j];
//                    f[j] = t;
//                }
//            }
//        }
//        // 按实力差距范围分组
//        List<List<Byte>> groups = new ArrayList<>(n);
//        List<Byte> temp = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            List<Byte> g = new ArrayList<>();
//            g.add(f[i]);
//            // 加上范围内实力大的
//            if (i < n - 1) {
//                for (int j = i + 1; j < n; j++) {
//                    if (f[j] - f[i] < d) {
//                        g.add(f[j]);
//                    } else {
//                        break;
//                    }
//                }
//            }
//            // 加上范围内实力小的，！按顺序加上！
//            if (i > 1) {
//                temp.clear();
//                for (int j = i - 1; j > 0; j--) {
//                    if (f[i] - f[j] < d) {
//                        temp.add(f[j]);
//                    } else {
//                        break;
//                    }
//                }
//                for (int j = temp.size() - 1; j > 0; j--) {
//                    g.add(temp.get(j));
//                }
//            }
//            groups.add(g);
//        }
//        int sumD = -1; // 实力和
//        List<Pair> pairs = new ArrayList<Pair>(); // 保存匹配好的组
//        // 如果每组只有一个人则无法匹配返回-1
//        boolean isNan = true;
//        for (int i = 0; i < groups.size(); i++) {
//            if (groups.get(i).size() != 1) {
//                isNan = false;
//                sumD = 0;
//                break;
//            }
//        }
//        // 可匹配
//        if (!isNan) {
//            // 未匹配
//            List<Byte> noPair = new ArrayList<>();
//            // 邻近匹配
//            for (byte i = 0; i < groups.size();) {
//                // 忽略无法匹配的队伍
//                List<Byte> pair = groups.get(i);
//                if (pair.size() > 1) {
//                    if (pair.size() % 2 == 0) {
//                        for (byte j = (byte)(pair.size() - 1); j>0; j-=2) {
//                            int t = pair.get(j) - pair.get(j-1);
//                            sumD += t;
//                            pairs.add(new Pair((byte) (j-1), j));
//                            System.out.println("pair " + j + "+" + (j-1)+",t="+t);
//                        }
//                        i+=pair.size();
//                    } else {
//
//                    }
//                } else {
//                    i ++;
//                }
//            }
//        }
//        System.out.println(sumD);
//    }
//
//    private static class Pair{
//        byte i, j;
//        public Pair(byte i, byte j) {
//            this.i = i;
//            this.j = j;
//        }
//    }
}
