package leetcode.java.general;
// Java Program to Check if the given number is prime?
public class CheckGivenNumberIsPrimeOrNOt {

    public static void main(String[] args) {
        int number = 11;

        System.out.println(isPrime(number));
    }

    private static boolean isPrime(int number) {
        if(number<=1) return  false;
        for(int i=2; i<=Math.sqrt( number );i++){
            if(number %i ==0) return false;
        }
        return true;
    }
}
