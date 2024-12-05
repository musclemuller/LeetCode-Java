package problems._87_ScrambleString;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        boolean[][][] f = new boolean[n][n][n + 1];

        // 先处理长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 再处理其余长度情况
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        if (a || b) {
                            f[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }

    public static void main(String[] args) {
        ScrambleString solution = new ScrambleString();
        
        // Test Case 1: s1 = "great", s2 = "rgeat"
        // Expected: true
        System.out.println("Test Case 1:");
        System.out.println("Input: s1 = \"great\", s2 = \"rgeat\"");
        System.out.println("Output: " + solution.isScramble("great", "rgeat"));
        
        // Test Case 2: s1 = "abcde", s2 = "caebd" 
        // Expected: false
        System.out.println("\nTest Case 2:");
        System.out.println("Input: s1 = \"abcde\", s2 = \"caebd\"");
        System.out.println("Output: " + solution.isScramble("abcde", "caebd"));
        
        // Test Case 3: s1 = "a", s2 = "a"
        // Expected: true
        System.out.println("\nTest Case 3:");
        System.out.println("Input: s1 = \"a\", s2 = \"a\"");
        System.out.println("Output: " + solution.isScramble("a", "a"));
    }
} 