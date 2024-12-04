package problems._76_MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int start = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;

        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (r - l < len) {
                    len = r - l;
                    start = l;
                }
                char d = s.charAt(l);
                l++;
                if (window.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d) < need.get(d)) {
                        valid--;
                    }
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        // Test Case 1: Basic example with s="ADOBECODEBANC", t="ABC"
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s1, t1) + "\"");
        System.out.println("Expected: \"BANC\"");
        System.out.println();

        // Test Case 2: Minimal case where s=t="a"
        String s2 = "a", t2 = "a";
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s2, t2) + "\"");
        System.out.println("Expected: \"a\"");
        System.out.println();

        // Test Case 3: Case where no valid window exists
        String s3 = "a", t3 = "aa";
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s3, t3) + "\"");
        System.out.println("Expected: \"\"");
        System.out.println();
    }
} 
