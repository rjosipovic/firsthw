package home.playground.second;

import home.playground.common.StringConcatenator;
import home.playground.common.UserInput;

import java.util.StringJoiner;

public class SecondMain {

    private static int STR_MIN_LENGTH = 2;

    public static void main(String[] args) {

        String input = UserInput.acceptString(STR_MIN_LENGTH);
        String[] palindromes = BiggestPalindrome.findBiggestPalindrome(input);
        if(palindromes.length == 0) {
            System.out.println("No palindromes found!");
        } else {
            System.out.println(String.format("Longest palindromes are: %s", formatPalindromes(palindromes)));
        }
    }

    private static String formatPalindromes(String[] palindromeArray) {
        StringConcatenator concatenate = new StringConcatenator(' ');
        for(String palindrome : palindromeArray) {
            concatenate.add(palindrome);
        }
        return concatenate.toString();
    }
}
