// Given a string s, find the length of the longest substringwithout repeating characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

import java.util.HashMap;
import java.util.Map;

// Sliding Window
// Complexity Analysis
// Time complexity : O(2n)=O(n). In the worst case each character will be visited twice by i and j.

// Space complexity : O(min(m,n)). Same as the previous approach. We need O(k) space for the sliding window, where k is the size of the Set. 
// The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
            while (charToFreq.get(c) > 1) {
                char del = s.charAt(l);
                l++;
                charToFreq.put(del, charToFreq.get(del) - 1);
                //charToFreq.remove(del);
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String teString = "abcabcbb";
        System.out.println(s.lengthOfLongestSubstring(teString));
    }
}
