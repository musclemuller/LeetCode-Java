# [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

Each digit maps to a set of letters, similar to a traditional telephone keypad. Note that `1` does not map to any letters.

---

![Mapping of Digits to Letters](../../Image/17.png)

---

## Examples

### Example 1
- **Input:** `digits = "23"`
- **Output:** `["ad","ae","af","bd","be","bf","cd","ce","cf"]`

### Example 2
- **Input:** `digits = ""`
- **Output:** `[]`
- **Explanation:** No digits, so no letter combinations.

### Example 3
- **Input:** `digits = "2"`
- **Output:** `["a","b","c"]`

---

## Constraints
- `0 <= digits.length <= 4`
- `digits[i]` is a digit in the range `['2', '9']`
