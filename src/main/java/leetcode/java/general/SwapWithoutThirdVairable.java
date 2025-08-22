package leetcode.java.general;

//How to swap two numbers without using a third variable?
public class SwapWithoutThirdVairable {
    public static void main(String[] args) {
        swap();
    }

    private static void swap() {
        int a =10;
        int b =12;


        a = a + b; // a becomes 22
        b = a - b; // b becomes 10
        a = a - b; // a becomes 12


        System.out.println("After swap: a = " + a + ", b = " + b);

    }
}
