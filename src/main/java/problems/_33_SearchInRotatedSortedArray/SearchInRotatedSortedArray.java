package problems._33_SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (nums[pivot] == target) return pivot;
        int res = findTarget(nums, 0, pivot - 1, target);
        if (res == -1) {
            res = findTarget(nums, pivot + 1, nums.length - 1, target);
        }
        return res;
    }

    int findTarget(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }

        return -1;
    }

    int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l; 
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
    }
}
