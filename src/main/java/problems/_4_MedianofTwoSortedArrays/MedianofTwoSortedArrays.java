package problems._4_MedianofTwoSortedArrays;
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        if (len % 2 == 1) {
            return findKth(nums1, nums2, len / 2 + 1);
        } else {
            return (findKth(nums1, nums2, len / 2 + 1) + findKth(nums1, nums2, len / 2)) / 2.0;
        }
    }

    int findKth(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int idx1 = 0, idx2 = 0;
        while (true) {
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }

            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            int half = k / 2;
            int newIdx1 = Math.min(nums1.length, half + idx1) - 1;
            int newIdx2 = Math.min(nums2.length, half + idx2) - 1;
            int pivot1 = nums1[newIdx1], pivot2 = nums2[newIdx2];
            if(pivot1 <= pivot2) {
                k -= newIdx1 - idx1 + 1;
                idx1 = newIdx1 + 1;
            } else {
                k -= newIdx2 - idx2 + 1;
                idx2 = newIdx2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        MedianofTwoSortedArrays s = new MedianofTwoSortedArrays();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
