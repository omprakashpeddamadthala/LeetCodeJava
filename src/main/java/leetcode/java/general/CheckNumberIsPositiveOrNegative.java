package leetcode.java.general;

//Java Program to Check if a Number is Positive or Negative
public class CheckNumberIsPositiveOrNegative {

    public static void main(String[] args) {
        int number = -9;
        System.out.println(checkNumberPositiveOrNegative(number));
    }

    private static String checkNumberPositiveOrNegative(int number) {
        return number >0 ? "Positive " : "Negative";
    }
}
