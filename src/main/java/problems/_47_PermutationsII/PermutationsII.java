package problems._47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> res;
    LinkedList<Integer> track;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        track = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII s = new PermutationsII();
        System.out.println(s.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(s.permuteUnique(new int[]{1, 2, 3}));
    }
}
