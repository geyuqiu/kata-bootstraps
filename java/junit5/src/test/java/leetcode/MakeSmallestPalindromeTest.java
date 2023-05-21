package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MakeSmallestPalindromeTest {
    MakeSmallestPalindrome makeSmallestPalindrome = new MakeSmallestPalindrome();

    @Test
    void makeSm() {
        assertEquals("appa", makeSmallestPalindrome.makeSmallestPalindrome("apto"));
        assertEquals("efcfe", makeSmallestPalindrome.makeSmallestPalindrome("egcfe"));
        assertEquals("cc", makeSmallestPalindrome.makeSmallestPalindrome("gc"));
    }
}
