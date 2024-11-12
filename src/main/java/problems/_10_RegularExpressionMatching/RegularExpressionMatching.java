package problems._10_RegularExpressionMatching;

import java.util.Arrays;

public class RegularExpressionMatching {
    int[][] memo;

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, p, 0);
    }

    boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean res = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // match
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                return dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                return dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }

    public static void main(String[] args) {
        RegularExpressionMatching s = new RegularExpressionMatching();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("ab", ".*"));
    }
}
