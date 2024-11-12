# [Integer to Roman](https://leetcode.com/problems/integer-to-roman/description/)

Seven different symbols represent Roman numerals with the following values:

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral follows these rules:

1. **Standard Conversion**: If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and continue with the remainder.
2. **Subtractive Notation**: If the value starts with 4 or 9, use the subtractive form, where a smaller numeral precedes a larger numeral, e.g., 4 is represented as "IV" (5 - 1), and 9 as "IX" (10 - 1). The following subtractive forms are used: IV (4), IX (9), XL (40), XC (90), CD (400), and CM (900).
3. **Repetition Rules**: Only powers of 10 (I, X, C, M) can be appended consecutively up to three times. Symbols representing 5 (V, L, D) cannot be repeated. Instead, use the subtractive form when four of the same symbol are required.

Given an integer, convert it to a Roman numeral.

---

## Examples

### Example 1
- **Input:** `num = 3749`
- **Output:** `"MMMDCCXLIX"`
- **Explanation:**
  - `3000 = MMM` as 1000 (M) + 1000 (M) + 1000 (M)
  - `700 = DCC` as 500 (D) + 100 (C) + 100 (C)
  - `40 = XL` as 10 (X) less than 50 (L)
  - `9 = IX` as 1 (I) less than 10 (X)

### Example 2
- **Input:** `num = 58`
- **Output:** `"LVIII"`
- **Explanation:**
  - `50 = L`
  - `8 = VIII`

### Example 3
- **Input:** `num = 1994`
- **Output:** `"MCMXCIV"`
- **Explanation:**
  - `1000 = M`
  - `900 = CM`
  - `90 = XC`
  - `4 = IV`

---

## Constraints
- `1 <= num <= 3999`
