package problems._91_DecodeWays;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) {
                f[i] = f[i - 1];
            } 
            if (10 <= b && b <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        
        // Test Case 1: s = "12"
        System.out.println("Test Case 1:");
        System.out.println("Input: s = \"12\"");
        System.out.println("Output: " + solution.numDecodings("12"));
        // Expected Output: 2
        // Explanation: "12" could be decoded as "AB" (1 2) or "L" (12)
        
        // Test Case 2: s = "226"
        System.out.println("\nTest Case 2:");
        System.out.println("Input: s = \"226\"");
        System.out.println("Output: " + solution.numDecodings("226")); 
        // Expected Output: 3
        // Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
        
        // Test Case 3: s = "06"
        System.out.println("\nTest Case 3:");
        System.out.println("Input: s = \"06\"");
        System.out.println("Output: " + solution.numDecodings("06"));
        // Expected Output: 0
        // Explanation: "06" cannot be mapped to "F" because of the leading zero
    }
} 