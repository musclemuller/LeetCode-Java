package problems._34_FindFirstAndLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            leftBound(nums, target),
            rightBound(nums, target)
        };
    }

    int leftBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        if (l < 0 || l >= nums.length) {
            return -1;
        }

        return nums[l] == target ? l : -1;
    }

    int rightBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        if (l - 1 < 0 || l - 1 >= nums.length) {
            return -1;
        }

        return nums[l - 1] == target ? l - 1 : -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray s = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
    }
}
