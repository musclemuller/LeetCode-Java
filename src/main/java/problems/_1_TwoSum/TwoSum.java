package problems._1_TwoSum;

import java.util.HashMap;
import java.util.Map;;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] res = s.twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}