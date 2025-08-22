package leetcode.java.general;

//Java Program to Find Sum of Natural Numbers
public class FindSumOfNaturalNumbers {
    public static void main(String[] args) {
        int number =  5;
        System.out.println(findSumNaturalNumbers(number));

    }

    private static int findSumNaturalNumbers(int number) {
        int sum =0;
        for (int i=0;i<= number;i++){
            sum = sum+i;
        }
        return sum;
    }
}
