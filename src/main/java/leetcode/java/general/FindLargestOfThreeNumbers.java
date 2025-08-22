package leetcode.java.general;

//Java Program to Find Largest of Three Numbers
public class FindLargestOfThreeNumbers {
    public static void main(String[] args) {
        int a =12,b= 11,c=10;
        int largest =0;

        if(a>b & a>c){
            largest =a;
        } else if (b>a && b >c) {
            largest =b;
        }else  {
            largest =c;
        }

        System.out.println("largest "+largest);
    }
}
