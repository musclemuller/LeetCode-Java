package problems._18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> triples = threeSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> triple : triples) {
                triple.add(nums[i]);
                res.add(triple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    List<List<Integer>> threeSumTarget(int[] nums, int start, long target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1,  target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, long target) {
        int left = start, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int l = nums[left], r = nums[right];
            if (sum == target) {
                List<Integer> tuple = new ArrayList<>();
                tuple.add(l);
                tuple.add(r);
                res.add(tuple);
                while (left < right && nums[left] == l) {
                    left++;
                }
                while (left < right && nums[right] == r) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == l) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == r) {
                    right--;
                }
            }
        } 

        return res;
    }

    public static void main(String[] args) {
        FourSum s = new FourSum();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(s.fourSum(nums, target));
    }
}
