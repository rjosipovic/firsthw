package home.playground.second;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class PalindromeTest {

    @Test
    public void isPalindromeTest1() {
        Assert.assertTrue(Palindrome.isPalindrome("atta"));
    }

    @Test
    public void isPalindromeTest2() {
        Assert.assertTrue(Palindrome.isPalindrome("radar"));
    }

    @Test
    public void isPalindromeTest3() {
        Assert.assertTrue(Palindrome.isPalindrome("bab"));
    }

    @Test
    public void isPalindromeTest4() {
        Assert.assertFalse(Palindrome.isPalindrome("barbarian"));
    }

    @Test
    public void isPalindromeTest5() {
        Assert.assertTrue(Palindrome.isPalindrome("aa"));
    }

    @Test
    public  void testPalindrome1() {
        String[] palindromes = BiggestPalindrome.findBiggestPalindrome("barbarian");
        Assert.assertTrue(palindromes.length == 0);
    }

    @Test
    public  void testPalindrome2() {
        String[] palindromes = BiggestPalindrome.findBiggestPalindrome("gattaca");
        Assert.assertTrue(palindromes.length == 1);
        Assert.assertEquals("atta", palindromes[0]);
    }

    @Test
    public  void testPalindrome3() {
        String[] palindromes = BiggestPalindrome.findBiggestPalindrome("baba");
        Assert.assertTrue(palindromes.length == 2);
        Assert.assertEquals("bab", palindromes[0]);
        Assert.assertEquals("aba", palindromes[1]);
    }

    @Test
    public  void testPalindrome4() {
        String[] palindromes = BiggestPalindrome.findBiggestPalindrome("saippuakivikauppias");
        Assert.assertTrue(palindromes.length == 1);
        Assert.assertEquals("saippuakivikauppias", palindromes[0]);
    }
}
