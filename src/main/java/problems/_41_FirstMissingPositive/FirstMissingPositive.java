package problems._41_FirstMissingPositive;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive s = new FirstMissingPositive();
        int[] nums1 = new int[]{1,2,0};
        int[] nums2 = new int[]{3,4,-1,1};
        int[] nums3 = new int[]{7,8,9,11,12};
        System.out.println(s.firstMissingPositive(nums1));
        System.out.println(s.firstMissingPositive(nums2));
        System.out.println(s.firstMissingPositive(nums3));
    }
}
