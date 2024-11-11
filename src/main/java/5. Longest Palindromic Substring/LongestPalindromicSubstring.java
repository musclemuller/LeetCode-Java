// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:
// Input: s = "cbbd"
// Output: "bb"
 
// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.



// Check All Substrings
// Complexity Analysis

// Given n as the length of s,

// Time complexity: O(n^3)
// The two nested for loops iterate O(n^2) times. We check one substring of length n, two substrings of length n - 1, three substrings of length n - 2, and so on.
// There are n substrings of length 1, but we don't check them all since any substring of length 1 is a palindrome, and we will return immediately.

// Therefore, the number of substrings that we check in the worst case is 1 + 2 + 3 + ... + n - 1. This is the partial sum of this series for n - 1, 
// which is equal to  n⋅(n−1) / 2 = O(n^2).

// In each iteration of the while loop, we perform a palindrome check. The cost of this check is linear with n as well, giving us a time complexity of O(n^3).

// Note that this time complexity is in the worst case and has a significant constant divisor that is dropped by big O. 
// Due to the optimizations of checking the longer length substrings first and exiting the palindrome check early if we determine that a substring cannot be a palindrome, 
// the practical runtime of this algorithm is not too bad.

// Space complexity: O(1)
// We don't count the answer as part of the space complexity. Thus, all we use are a few integer variables.


public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String r1 = getPalindrome(s, i, i);
            String r2 = getPalindrome(s, i, i + 1);
            res = res.length() > r1.length() ? res : r1;
            res = res.length() > r2.length() ? res : r2;
        }
        return res;
    }

    String getPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("babad"));
    }
}
