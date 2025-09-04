package leetcode.java.general;

public class ReverseNumber {

    public static void main(String[] args) {
        int number =123456789;
        int reversedNumber = 0;

        while(number>0){
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit; //append each digit
            number = number/10;
        }

        System.out.println(reversedNumber);
    }
}
