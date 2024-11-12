[Problem Link](https://leetcode.com/problems/longest-palindromic-substring/description/)

Given a string `s`, return the longest palindromic substring in `s`.

### Example 1:
- **Input:** `s = "babad"`
- **Output:** `"bab"`
- **Explanation:** `"aba"` is also a valid answer.

### Example 2:
- **Input:** `s = "cbbd"`
- **Output:** `"bb"`

### Constraints:
- `1 <= s.length <= 1000`
- `s` consists of only digits and English letters.

### Solution:
### Approach: Check All Substrings

#### Complexity Analysis:
- **Time Complexity:** \( O(n^3) \)
  - The two nested `for` loops iterate \( O(n^2) \) times.
  - We check one substring of length `n`, two substrings of length `n - 1`, three substrings of length `n - 2`, and so on.
  - The number of substrings checked in the worst case is the sum \( 1 + 2 + 3 + ... + (n - 1) = \frac{n \cdot (n - 1)}{2} = O(n^2) \).
  - Each palindrome check costs \( O(n) \), resulting in a total time complexity of \( O(n^3) \).

  - Note: This is the worst-case complexity, but optimizations like checking longer substrings first and exiting early if a substring cannot be a palindrome improve practical runtime.

- **Space Complexity:** \( O(1) \)
  - Only a few integer variables are used, and we don't count the answer as part of the space complexity.
