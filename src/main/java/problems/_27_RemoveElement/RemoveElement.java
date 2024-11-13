package problems._27_RemoveElement;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveElement s = new RemoveElement();
        int[] nums1 = new int[]{3,2,2,3};
        int[] nums2 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(s.removeElement(nums1, 3));;
        System.out.println(s.removeElement(nums2, 2));;
    }
}
