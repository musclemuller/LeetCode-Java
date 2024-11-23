package problems._55_JumpGame;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int f = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            f = Math.max(f, i + nums[i]);
            if (f <= i) {
                return false;
            }
        }

        return f >= n - 1;
    }

    public static void main(String[] args) {
        JumpGame s = new JumpGame();
        
        // Test case 1
        System.out.println("Test case 1:");
        int[] nums1 = {2,3,1,1,4};
        boolean result1 = s.canJump(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: true");
        System.out.println("Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.");
        System.out.println("Test case 1 " + (result1 == true ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2
        System.out.println("Test case 2:");
        int[] nums2 = {3,2,1,0,4};
        boolean result2 = s.canJump(nums2);
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: false");
        System.out.println("Explanation: You will always arrive at index 3 no matter what." +
                         " Its maximum jump length is 0, which makes it impossible to reach the last index.");
        System.out.println("Test case 2 " + (result2 == false ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Additional test cases
        // Test case 3: Single element array
        System.out.println("Test case 3 (Single element array):");
        int[] nums3 = {0};
        boolean result3 = s.canJump(nums3);
        System.out.println("Input: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);
        System.out.println("Expected: true");
        System.out.println("Test case 3 " + (result3 == true ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: All zeros except last
        System.out.println("Test case 4 (All zeros except last):");
        int[] nums4 = {0,0,0,0,1};
        boolean result4 = s.canJump(nums4);
        System.out.println("Input: nums = " + Arrays.toString(nums4));
        System.out.println("Output: " + result4);
        System.out.println("Expected: false");
        System.out.println("Test case 4 " + (result4 == false ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 5: Every position can jump to end
        System.out.println("Test case 5 (Every position can jump to end):");
        int[] nums5 = {5,4,3,2,1};
        boolean result5 = s.canJump(nums5);
        System.out.println("Input: nums = " + Arrays.toString(nums5));
        System.out.println("Output: " + result5);
        System.out.println("Expected: true");
        System.out.println("Test case 5 " + (result5 == true ? "PASSED" : "FAILED"));
    }
}
