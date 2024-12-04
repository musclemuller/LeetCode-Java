package problems._78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res;
    List<Integer> track;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();

        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        // Test Case 1: Basic example with nums = [1,2,3]
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1));
        System.out.println("Output: " + solution.subsets(nums1));
        System.out.println("Expected: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]");
        System.out.println();

        // Test Case 2: Minimal case with nums = [0]
        int[] nums2 = {0};
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2));
        System.out.println("Output: " + solution.subsets(nums2));
        System.out.println("Expected: [[],[0]]");
        System.out.println();
    }
} 
