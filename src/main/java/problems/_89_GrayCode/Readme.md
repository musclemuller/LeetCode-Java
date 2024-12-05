# [Gray Code](https://leetcode.com/problems/gray-code/)

An **n-bit gray code sequence** is a sequence of `2^n` integers where:
- Every integer is in the inclusive range `[0, 2^n - 1]`,
- The first integer is _0_,
- An integer appears **no more than once** in the sequence,
- The binary representation of every pair of **adjacent** integers differs by **exactly one bit**, and
- The binary representation of the **first** and **last** integers differs by **exactly one bit**.

Given an integer `n`, return *any valid* **n-bit gray code sequence**.

---

## Examples

### Example 1:
> **Input:** `n = 2`  
> **Output:** `[0,1,3,2]`  
> **Explanation:**  
> The binary representation of [0,1,3,2] is [_00_,_01_,_11_,_10_].
> - _00_ and _01_ differ by one bit
> - _01_ and _11_ differ by one bit
> - _11_ and _10_ differ by one bit
> - _10_ and _00_ differ by one bit
> [0,2,3,1] is also a valid gray code sequence, whose binary representation is [_00_,_10_,_11_,_01_].
> - _00_ and _10_ differ by one bit
> - _10_ and _11_ differ by one bit
> - _11_ and _01_ differ by one bit
> - _01_ and _00_ differ by one bit

### Example 2:
> **Input:** `n = 1`  
> **Output:** `[0,1]`

---

## Constraints:
- `1 <= n <= 16`