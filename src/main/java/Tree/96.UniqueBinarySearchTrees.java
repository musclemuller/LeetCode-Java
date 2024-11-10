package Tree;

// Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
// Example 1:
// ![Example Image](../Image/96.png)

// Input: n = 3
// Output: 5
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 19

class UniqueBinarySearchTrees {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo > hi) return 1;
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;

        for (int i = lo; i <= hi; i++) {
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            res += left * right;
        }

        memo[lo][hi] = res;
        return res;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        System.out.println(s.numTrees(3));
    }
}
