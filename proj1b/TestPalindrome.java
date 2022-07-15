import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word1 = "noon";
        boolean res1 = palindrome.isPalindrome(word1);
        assertTrue(res1);

        String word2 = "horse";
        boolean res2 = palindrome.isPalindrome(word2);
        assertFalse(res2);

        String word3 = "";
        boolean res3 = palindrome.isPalindrome(word3);
        assertTrue(res3);
    }

    @Test
    public void TestOverloadedIsPalindrome() {
        CharacterComparator cc = new OffByOne();
        String word = "flake";
        boolean res = palindrome.isPalindrome(word, cc);
        assertTrue(res);
    }
}
