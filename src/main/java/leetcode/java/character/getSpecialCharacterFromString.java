package leetcode.java.character;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class getSpecialCharacterFromString {

    public static void main(String[] args) {
        String input = "Hell@ @mPr@k@$h thi$ secrect c@de ##**&&%%  ";

        System.out.println(getSpecialCharacterFromStringUsingStreams(input));
        System.out.println(getSpecialCharacterFromStringUsingWithOutStreams(input));
    }

    private static String getSpecialCharacterFromStringUsingWithOutStreams(  String input) {
        char array[] = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if(!Character.isLetterOrDigit(array[i]) && !Character.isWhitespace(array[i]))  sb.append(array[i]);
        }
        return sb.toString();
    }

    private static String getSpecialCharacterFromStringUsingStreams(  String input) {

         return input.chars().mapToObj(ch -> (char) ch)
                 .filter(character -> !Character.isLetterOrDigit(character) && !Character.isWhitespace(character))
                 .map(ch->String.valueOf(ch))
                 .collect(Collectors.joining());

    }
}
