package problems._40_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    List<List<Integer>> res;
    LinkedList<Integer> track;
    int trackSum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new LinkedList<>();
        trackSum = 0;
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    void backtrack(int[] nums, int start, int target) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            trackSum += nums[i];
            track.addLast(nums[i]);

            backtrack(nums, i + 1, target);
            trackSum -= nums[i];
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumII s = new CombinationSumII();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> reList = s.combinationSum2(candidates, target);
        System.out.println(reList);
    }
}
