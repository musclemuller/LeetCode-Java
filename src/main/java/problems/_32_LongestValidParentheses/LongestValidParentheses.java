package problems._32_LongestValidParentheses;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else {
                stk.pop();
                if (stk.isEmpty()) {
                    stk.push(i);
                } else {
                    max = Math.max(max, i - stk.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses s = new LongestValidParentheses();
        System.out.println(s.longestValidParentheses("(()"));
        System.out.println(s.longestValidParentheses(")()())"));
        System.out.println(s.longestValidParentheses(""));
    }
}
