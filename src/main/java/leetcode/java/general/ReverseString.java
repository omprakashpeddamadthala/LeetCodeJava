package leetcode.java.general;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Om Prakash";
        System.out.println(reverseString(input));
        System.out.println(reverseStringWithRecursion(input));
        System.out.println(reverseStringWithoutInbuiltMethods(input));
    }

    private static String reverseStringWithRecursion(String input) {
        return  reverse(input);
    }

    private static String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        return reverse(input.substring(1))+input.charAt(0);
    }

    private static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    private static String reverseStringWithoutInbuiltMethods(String input) {
        String reversString = "";
        char ch[] = input.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            reversString = reversString + ch[i];
        }
        return reversString;
    }
}
