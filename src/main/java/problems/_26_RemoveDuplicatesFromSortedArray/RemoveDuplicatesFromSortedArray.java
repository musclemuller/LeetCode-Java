package problems._26_RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(s.removeDuplicates(nums1));
        System.out.println(s.removeDuplicates(nums2));
    }
}
