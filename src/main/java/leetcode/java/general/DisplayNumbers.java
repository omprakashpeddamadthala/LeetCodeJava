package leetcode.java.general;

import java.util.ArrayList;
import java.util.List;

//Java Program to Display Even Numbers From 1 to 100
public class DisplayNumbers {

    public static void main(String[] args) {

        System.out.println(displayEvenNumbers());
        System.out.println(displayOddNumbers());
    }

    private static List<Integer> displayEvenNumbers() {
        List<Integer> evenNumberList= new ArrayList<>();
        for(int i=1;i<=100 ;i++){
            if(i %2 ==0){
                evenNumberList.add( i );
            }
        }
        return evenNumberList;
    }
    private static List<Integer> displayOddNumbers() {
        List<Integer> evenNumberList= new ArrayList<>();
        for(int i=1;i<=100 ;i++){
            if(i %2 !=0){
                evenNumberList.add( i );
            }
        }
        return evenNumberList;
    }

}
