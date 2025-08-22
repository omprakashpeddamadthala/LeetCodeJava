package leetcode.java.general;

// Java Program to check if a vowel is present in the string?
public class CheckVowelPresentInString {

    public static void main(String[] args) {

        String input = "Om Prakash";
        System.out.println(checkVowelInPresent(input));

    }

    private static boolean checkVowelInPresent(String input) {
        return  input.toLowerCase().matches( ".*[aeiou].*" );
    }
}
