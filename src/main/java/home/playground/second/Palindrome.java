package home.playground.second;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while(str.charAt(i) == str.charAt(j) && i < j) {
            i++;
            j--;
        }
        return i >= j;
    }
}
