package problems._22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    StringBuilder track;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        track = new StringBuilder();
        res = new ArrayList<>();
        if (n == 0) return res;
        backtrack(n, n);
        return res;
    }

    void backtrack(int left, int right) {
        if (right < left) return;
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        track.append('(');
        backtrack(left - 1, right);
        track.deleteCharAt(track.length() - 1);

        track.append(')');
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }

    public static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
    }
}
