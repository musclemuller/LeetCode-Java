package problems._81_SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        int idx = n;
        if (nums[r] >= nums[0] && r + 1 < n) idx = r + 1;
        int ans = find(nums, 0, idx - 1, t);
        if (ans != -1) return true;
        ans = find(nums, idx, n - 1, t);
        return ans != -1;
    }

    int find(int[] nums, int l, int r, int t) {
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] == t ? r : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();

        // Test Case 1: Target exists in rotated array with duplicates
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        int target1 = 0;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + solution.search(nums1, target1));
        System.out.println("Expected: true");
        System.out.println();

        // Test Case 2: Target does not exist in rotated array with duplicates
        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        int target2 = 3;
        System.out.println("Input: nums = " + java.util.Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + solution.search(nums2, target2));
        System.out.println("Expected: false");
        System.out.println();
    }
} 