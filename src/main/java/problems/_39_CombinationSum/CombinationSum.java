package problems._39_CombinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;
    LinkedList<Integer> track;
    int trackSum;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        trackSum = 0;
        this.target = target;
        // Arrays.sort(candidates);
        backtrack(candidates, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (trackSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            trackSum += nums[i];
            track.addLast(nums[i]);
            backtrack(nums, i);
            track.removeLast();
            trackSum -= nums[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        int[] candidates =new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> reList = s.combinationSum(candidates, target);
        System.out.println(reList);
    }
}
