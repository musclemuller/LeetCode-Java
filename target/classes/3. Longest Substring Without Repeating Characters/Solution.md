[Problem Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

Given a string `s`, find the length of the longest substring without repeating characters.

### Example 1:
- **Input:** `s = "abcabcbb"`
- **Output:** `3`
- **Explanation:** The answer is `"abc"`, with the length of `3`.

### Example 2:
- **Input:** `s = "bbbbb"`
- **Output:** `1`
- **Explanation:** The answer is `"b"`, with the length of `1`.

### Example 3:
- **Input:** `s = "pwwkew"`
- **Output:** `3`
- **Explanation:** The answer is `"wke"`, with the length of `3`.
  - **Note:** The answer must be a substring. `"pwke"` is a subsequence, not a substring.

### Constraints:
- `0 <= s.length <= 5 * 10^4`
- `s` consists of English letters, digits, symbols, and spaces.

### Solution:
- **Approach:** Sliding Window
- **Complexity Analysis:**
  - **Time Complexity:** \( O(2n) = O(n) \). In the worst case, each character will be visited twice by pointers `i` and `j`.
  - **Space Complexity:** \( O(\min(m, n)) \). We need \( O(k) \) space for the sliding window, where \( k \) is the size of the Set. The Set's size is bounded by the string length \( n \) and the size of the charset/alphabet \( m \).
