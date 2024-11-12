package problems._14_LongestCommonPrefix;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                String thisStr = strs[row], prevStr = strs[row - 1];
                if (col >= thisStr.length() || col >= prevStr.length() ||
                    thisStr.charAt(col) != prevStr.charAt(col)) {
                        return strs[row].substring(0, col);
                    }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String[] tests1 = new String[]{"flower","flow","flight"};
        String[] tests2 = new String[]{"dog","racecar","car"};
        System.out.println(s.longestCommonPrefix(tests1));
        System.out.println(s.longestCommonPrefix(tests2));
    }
}
