package problems._88_MergeSortedArray;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int p = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }

        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        // Test Case 1: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // Expected: [1,2,2,3,5,6]
        System.out.println("Test Case 1:");
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println("Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3");
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("Output: " + java.util.Arrays.toString(nums1));

        // Test Case 2: nums1 = [1], m = 1, nums2 = [], n = 0
        // Expected: [1]
        System.out.println("\nTest Case 2:");
        int[] nums3 = {1};
        int[] nums4 = {};
        System.out.println("Input: nums1 = [1], m = 1, nums2 = [], n = 0");
        solution.merge(nums3, 1, nums4, 0);
        System.out.println("Output: " + java.util.Arrays.toString(nums3));

        // Test Case 3: nums1 = [0], m = 0, nums2 = [1], n = 1
        // Expected: [1]
        System.out.println("\nTest Case 3:");
        int[] nums5 = {0};
        int[] nums6 = {1};
        System.out.println("Input: nums1 = [0], m = 0, nums2 = [1], n = 1");
        solution.merge(nums5, 0, nums6, 1);
        System.out.println("Output: " + java.util.Arrays.toString(nums5));
    }
} 