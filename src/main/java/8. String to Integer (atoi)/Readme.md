# [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/description/)

Implement the `myAtoi(string s)` function, which converts a string to a 32-bit signed integer.

### Algorithm for `myAtoi(string s)`:
1. **Whitespace:** Ignore any leading whitespace.
2. **Signedness:** Determine the sign based on the presence of `'-'` or `'+'`. If neither is present, assume the integer is positive.
3. **Conversion:** Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits are read, the result is `0`.
4. **Rounding:** Clamp the integer within the 32-bit signed integer range `[-2^31, 2^31 - 1]`. If the integer is below `-2^31`, round to `-2^31`; if it exceeds `2^31 - 1`, round to `2^31 - 1`.

### Examples

#### Example 1:
- **Input:** `s = "42"`
- **Output:** `42`
- **Explanation:**
  - Step 1: `"42"` (no leading whitespace to read)
  - Step 2: `"42"` (no sign character found)
  - Step 3: `"42"` (`"42"` is read in)

#### Example 2:
- **Input:** `s = "   -042"`
- **Output:** `-42`
- **Explanation:**
  - Step 1: `"   -042"` (ignore leading whitespace)
  - Step 2: `"-"` (determine result as negative)
  - Step 3: `"042"` (skip leading zeros, read as `"-42"`)

#### Example 3:
- **Input:** `s = "1337c0d3"`
- **Output:** `1337`
- **Explanation:**
  - Step 1: `"1337c0d3"` (no whitespace to ignore)
  - Step 2: `"1337c0d3"` (no sign character found)
  - Step 3: `"1337"` (`"1337"` is read; reading stops at non-digit `"c"`)

#### Example 4:
- **Input:** `s = "0-1"`
- **Output:** `0`
- **Explanation:**
  - Step 1: `"0-1"` (no whitespace to ignore)
  - Step 2: `"0-1"` (no sign character found)
  - Step 3: `"0"` (`"0"` is read; stops at non-digit `"-"`)

#### Example 5:
- **Input:** `s = "words and 987"`
- **Output:** `0`
- **Explanation:** Reading stops at the first non-digit character `"w"`.

### Constraints:
- `0 <= s.length <= 200`
- `s` consists of English letters, digits (0-9), spaces (`' '`), `'+'`, `'-'`, and `'.'`.
