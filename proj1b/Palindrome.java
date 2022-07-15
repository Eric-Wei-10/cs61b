public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /* Helper function of isPalindrome */
    public boolean isPalindrome(String word, int index) {
        if (index == word.length() / 2) {
            return true;
        }
        if (word.charAt(index) == word.charAt(word.length() - 1 - index)) {
            return isPalindrome(word, index + 1);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(word, 0);
    }

    /* Helper function of overloaded isPalindrome */
    public boolean isPalindrome(String word, CharacterComparator cc, int index) {
        if (index == word.length() / 2) {
            return true;
        }
        if (cc.equalChars(word.charAt(index), word.charAt(word.length() - 1 - index))) {
            return isPalindrome(word, cc, index + 1);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(word, cc, 0);
    }
}
