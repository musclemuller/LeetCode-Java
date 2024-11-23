# [N-Queens](https://leetcode.com/problems/n-queens/)

The **n-queens** puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return **all distinct solutions** to the **n-queens puzzle**. You may return the answer in **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

---

## Examples

### Example 1
![Example 1 Graph](../../Image/51.png)
> **Input:**  
> `n = 4`  
>  
> **Output:**  
> ```plaintext
> [
>  [".Q..",
>   "...Q",
>   "Q...",
>   "..Q."],
> 
>  ["..Q.",
>   "Q...",
>   "...Q",
>   ".Q.."]
> ]
> ```
>  
> **Explanation:**  
> There exist two distinct solutions to the 4-queens puzzle as shown.  

---

### Example 2
> **Input:**  
> `n = 1`  
>  
> **Output:**  
> ```plaintext
> [["Q"]]
> ```

---

## Constraints
- `1 <= n <= 9`
