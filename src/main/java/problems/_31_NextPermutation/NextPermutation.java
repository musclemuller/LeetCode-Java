package problems._31_NextPermutation;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // find from end (i, j) : nums[i] < nums[j] -> cannot find, means nums decending, reverse nums
        // find from end in [j, end), the first nums[i] < nums[k]
        // switch i, k
        // reverse [j, end)

        int n = nums.length;
        int i = -1;
        for (int j = n - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) {
                i = j;
                break;
            }
        }

        if (i != -1) {
            int k = -1;
            for (int j = n - 1; j >= i + 1; j--) {
                if (nums[j] > nums[i]) {
                    // find k
                    k = j;
                    break;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;

            //reverse [j, end]
            reverse(nums, i + 1, n - 1);
        } else {
            reverse(nums, 0, n - 1);
        }
    }

    void reverse(int[] nums, int p, int q) {
        while (p < q) {
            int tmp = nums[p];
            nums[p] = nums[q];
            nums[q] = tmp;
            p++;
            q--;
        }
    }

    public static void main(String[] args) {
        NextPermutation s = new NextPermutation();
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{3, 2, 1};
        int[] nums3 = new int[]{1, 1, 5};
        s.nextPermutation(nums1);
        s.nextPermutation(nums2);
        s.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }
}
