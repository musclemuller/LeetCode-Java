package problems._80_RemoveDuplicatesFromSortedArrayII;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0, fast = 0;
        int count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && count < 2) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            count++;

            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                count = 0;
            }
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII solution = new RemoveDuplicatesFromSortedArrayII();
        
        // Test Case 1: Basic example with duplicates appearing more than twice
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1));
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Output: " + k1 + ", nums = " + java.util.Arrays.toString(nums1));
        System.out.println("Expected: 5, nums = [1, 1, 2, 2, 3, _]");
        System.out.println();

        // Test Case 2: Example with multiple duplicates
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2));
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("Output: " + k2 + ", nums = " + java.util.Arrays.toString(nums2));
        System.out.println("Expected: 7, nums = [0, 0, 1, 1, 2, 3, 3, _, _]");
        System.out.println();
    }
} 
