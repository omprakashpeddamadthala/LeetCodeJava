package leetcode.java.general;

public class FibinociiSeriesIUsingRecursion {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }


    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
