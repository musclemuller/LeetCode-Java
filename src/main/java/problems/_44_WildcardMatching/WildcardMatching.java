package problems._44_WildcardMatching;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // 获取长度，p（通配符）作为纵坐标，s（待匹配字符）作为横坐标
        int plen = p.length();
        int slen = s.length();
        // 初始化dp数组
        boolean table[][] = new boolean[plen + 1][slen + 1];
        // 初始化第一个元素
        table[0][0] = true;
        // 初始化第一行，p的第一个元素为*的情况，第一行的元素为true
        for (int i = 1; i <= slen; i++) {
            if (plen > 0 && p.charAt(0) == '*') {
                table[1][i] = true;
            } else {
                break;
            }
        }
        // 初始化第一列，p有几个*，数组就有几个元素为true
        for (int i = 1; i <= plen; i++) {
            if (p.charAt(i - 1) == '*') {
                table[i][0] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= plen; i++) {
            // 当前是否遇到*
            boolean isStar = false;
            for (int j = 1; j <= slen; j++) {
                //i为通配符的下标，j为待匹配字符串的下标，i为纵坐标，j为横坐标
                // 当前遇到*
                if (p.charAt(i - 1) == '*') {
                    // 处理第一列，p的第一个元素为*的情况
                    if (table[i - 1][0]) {
                        table[i][0] = true;
                    }
                    // 遇到*，且上一个元素为true，则当前元素为true
                    if (table[i - 1][j]) {
                        isStar = true;
                    }
                    if (isStar) {
                        table[i][j] = true;
                    }
                }
                // ?和字符匹配
                if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                }
            }
        }
        // 返回最后一个元素
        return table[plen][slen];
    }

    public static void main(String[] args) {
        WildcardMatching s = new WildcardMatching();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "*"));
        System.out.println(s.isMatch("cb", "?a"));
    }
}
