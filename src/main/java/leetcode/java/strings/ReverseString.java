package leetcode.java.strings;

public class ReverseString {

    public static void main(String[] args) {
        String input = "Om Prakash";
        System.out.println(reverseStingWithOutInBuiltMethods(input));
    }

    private static String reverseStingWithOutInBuiltMethods(String input) {
        char []chars = input.toCharArray();
        int left =0, right =chars.length-1;
        while (left<=right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf( chars );
    }
}
