package problems._77_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res;
    List<Integer> track;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backtrack(n, k, 1);
        return res;
    }

    private void backtrack(int n, int k, int start) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
        }

        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(n, k, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();

        // Test Case 1: Basic example with n=4, k=2
        int n1 = 4, k1 = 2;
        System.out.println("Input: n = " + n1 + ", k = " + k1);
        System.out.println("Output: " + solution.combine(n1, k1));
        System.out.println("Expected: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
        System.out.println();

        // Test Case 2: Minimal case with n=1, k=1 
        int n2 = 1, k2 = 1;
        System.out.println("Input: n = " + n2 + ", k = " + k2);
        System.out.println("Output: " + solution.combine(n2, k2));
        System.out.println("Expected: [[1]]");
        System.out.println();
    }
} 
