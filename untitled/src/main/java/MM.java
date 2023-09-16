public class MM {
    public static void main(String[] args) {
        Integer i = 0;
        System.out.println(i);
        a(i);
        System.out.println(i);
    }

    static void a(Integer i) {
        i = 2;
        System.out.println("in a " + i);
    }
}
