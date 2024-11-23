package problems._53_MaximumSubarray;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSubarray s = new MaximumSubarray();
    
        // Test case 1
        System.out.println("Test case 1:");
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int result1 = s.maxSubArray(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: 6");
        System.out.println("Test case 1 " + (result1 == 6 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2
        System.out.println("Test case 2:");
        int[] nums2 = {1};
        int result2 = s.maxSubArray(nums2);
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: 1");
        System.out.println("Test case 2 " + (result2 == 1 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3
        System.out.println("Test case 3:");
        int[] nums3 = {5,4,-1,7,8};
        int result3 = s.maxSubArray(nums3);
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);
        System.out.println("Expected: 23");
        System.out.println("Test case 3 " + (result3 == 23 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Additional test cases
        // Test case 4: All negative numbers
        System.out.println("Test case 4 (All negative numbers):");
        int[] nums4 = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        int result4 = s.maxSubArray(nums4);
        System.out.println("Input: nums = " + Arrays.toString(nums4));
        System.out.println("Output: " + result4);
        System.out.println("Expected: -1");
        System.out.println("Test case 4 " + (result4 == -1 ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 5: Empty array (edge case)
        System.out.println("Test case 5 (Empty array):");
        int[] nums5 = {};
        int result5 = s.maxSubArray(nums5);
        System.out.println("Input: nums = " + Arrays.toString(nums5));
        System.out.println("Output: " + result5);
        System.out.println("Expected: 0");
        System.out.println("Test case 5 " + (result5 == 0 ? "PASSED" : "FAILED"));
    }
}
