package leetcode.java.strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String array[] = {"aaabcd", "aaaers", "aaart"};
        System.out.println( findLongestCommonPrefix( array ) );
    }

    private static String findLongestCommonPrefix(String[] input) {
        if (input == null || input.length == 0) return "";
        String prefix = input[0];

        for (int i = 1; i < prefix.length(); i++) {
            while (input[i].indexOf( prefix ) != 0) {
                prefix = prefix.substring( 0, prefix.length() - 1 );
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
