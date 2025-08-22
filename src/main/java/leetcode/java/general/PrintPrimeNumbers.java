package leetcode.java.general;

// Prime Number Program in Java
public class PrintPrimeNumbers {
    public static void main(String[] args) {
        for (int i=2; i <=20;i++){
            if(isPrime( i )){
                System.out.println("prime number "+i);
            }
        }
    }

    public static boolean isPrime(int number){
        if(number<=1) return false;
        for(int i=2;i<=Math.sqrt( number );i++){
            if(number % i ==0)return false;
        }
        return true;
    }

}
