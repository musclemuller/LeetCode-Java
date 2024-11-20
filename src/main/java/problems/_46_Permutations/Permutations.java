package problems._46_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> res;
    LinkedList<Integer> track;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        track = new LinkedList<>();
        used = new boolean[nums.length];

        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations s = new Permutations();
        System.out.println(s.permute(new int[]{1, 2, 3}));
        System.out.println(s.permute(new int[]{0, 1}));
        System.out.println(s.permute(new int[]{1}));
    }
}
