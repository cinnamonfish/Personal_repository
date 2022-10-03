public class HelloWorld {
    


    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = s1;
        s1 = "world";
        // System.out.println("Hello, World");
        // System.out.println("s1: "+s1);
        // System.out.println("s2: "+s2);
        int[] a = new int[1000000];
        int[] b = new int[1000000];
        int[] t = a;
        a = b;
        b = t;
        System.out.println(a[0]);
    }
}
