package leetcode.java.character;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;

import java.sql.SQLOutput;
import java.util.stream.Collectors;

public class removeGivenCharacterInString {
    public static void main(String[] args) {

        String input ="I love java programming";

        System.out.println(withStreamsRemoveCharacter(input,'a'));
        System.out.println(withOutStramsRemoveCharacter(input,'a'));
    }

    private static String withOutStramsRemoveCharacter(String input, char a) {
        char array[] = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length ; i++) {
            if(array[i] !=a){
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }

    private static String withStreamsRemoveCharacter(String input, char a) {

        return  input.chars().mapToObj(ch -> (char) ch )
                .filter(ch->ch!=a)
                .map(ch -> String.valueOf(ch))
                .collect(Collectors.joining(""));

    }
}
