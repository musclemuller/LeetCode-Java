package problems._35_SearchInsertPosition;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
