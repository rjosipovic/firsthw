package home.playground.second;

import home.playground.common.StringConcatenator;

public class BiggestPalindrome {

    public static String[] findBiggestPalindrome(String str) {
        StringConcatenator biggestPalindromes = new StringConcatenator(';');
        int biggestPalindromeSize = 0;
         for(int i = 0; i < str.length() - 1; i++) {
             for(int j = i + 1; j < str.length(); j++) {
                 String s = str.substring(i, j+1);
                 if(Palindrome.isPalindrome(s)) {
                     if(s.length() > biggestPalindromeSize) {
                         biggestPalindromes = new StringConcatenator(';');
                         biggestPalindromes.add(s);
                         biggestPalindromeSize = s.length();
                     } else if(s.length() == biggestPalindromeSize) {
                         biggestPalindromes.add(s);
                     }
                 }
             }
         }
         if(biggestPalindromes.toString().isEmpty()) {
             String[] empty = {};
             return empty;
         } else {
             return biggestPalindromes.toString().split(";");
         }
    }
}
