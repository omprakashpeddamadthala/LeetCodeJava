package leetcode.java.general;

public class DivideStringNEqualParts {

    public static void main(String[] args) {
        String input ="abcdefghijklmnop";
        int number =5;

        if (input.length() % number != 0) {
            System.out.println("Sorry, we cannot divide into " + number + " equal parts.");
            return;
        }


        int partSize = input.length()/number;

        for(int i=0;i<input.length();i=i+partSize){
            System.out.println(input.substring(i,i+partSize));
        }
    }
}
