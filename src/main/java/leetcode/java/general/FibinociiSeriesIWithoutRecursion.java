package leetcode.java.general;

public class FibinociiSeriesIWithoutRecursion {

    public static void main(String[] args) {

        int a =0 ,b=1;
        int number =10;
        for(int i=2;i<=number;i++){
            int c = a+b;
            System.out.print(c+" ");
            b=a;
            a=c;

        }
    }
}
