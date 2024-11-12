public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        int index = 0;
        // remove leading 0
        while (index < len && cs[index] == ' ') {
            index++;
        }

        if (index == len) {
            return 0;
        }

        int sign = 1;
        char firstChar = cs[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        int res = 0;
        while (index < len) {
            char currChar = cs[index];
            if (currChar > '9' || currChar < '0') {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        StringToIntegerAtoi s = new StringToIntegerAtoi();
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("-042"));
        System.out.println(s.myAtoi("1337c0d3"));
        System.out.println(s.myAtoi("0-1"));
        System.out.println(s.myAtoi("words and 987"));
    }
}
