package problems._90_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res;
    List<Integer> track;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        
        // Test Case 1: nums = [1,2,2]
        int[] nums1 = {1, 2, 2};
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.subsetsWithDup(nums1));
        // Expected Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        
        // Test Case 2: nums = [0] 
        int[] nums2 = {0};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.subsetsWithDup(nums2));
        // Expected Output: [[],[0]]
    }
} 