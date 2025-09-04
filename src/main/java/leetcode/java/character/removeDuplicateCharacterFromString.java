package leetcode.java.character;

import java.util.stream.Collectors;

public class removeDuplicateCharacterFromString {

    public static void main(String[] args) {
        String input = "I love java Programming and groovy Grails also ";

        System.out.println("using Streams "+removeDuplicateCharacterFromStringUsingStreams(input));
        System.out.println("using without Streams "+removeDuplicateCharacterFromStringWithoutStreams(input));

    }

    private static String removeDuplicateCharacterFromStringWithoutStreams(String input) {
        StringBuilder result = new StringBuilder();
        boolean seen[] = new boolean[65536];
        for (Character ch :input.toCharArray()){
            if(!seen[ch]) {
              seen[ch] = true;
              result.append(ch);
            }
        }
        return result.toString();
    }

    private static Object removeDuplicateCharacterFromStringUsingStreams(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
