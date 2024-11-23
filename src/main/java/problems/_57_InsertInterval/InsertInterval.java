package problems._57_InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean placed = false;
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                if (!placed) {
                    placed = true;
                    res.add(new int[]{left, right});
                } 
                res.add(interval);
            }
            else if (interval[1] < left) {
                res.add(interval);
            }
            else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            res.add(new int[]{left, right});
        }

        int[][] nums = new int[res.size()][2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        
        // Test case 1
        System.out.println("Test case 1:");
        int[][] intervals1 = new int[][]{{1,3}, {6,9}};
        int[] newInterval1 = new int[]{2,5};
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals1) + 
                            ", newInterval = " + Arrays.toString(newInterval1));
        int[][] result1 = solution.insert(intervals1, newInterval1);
        int[][] expected1 = new int[][]{{1,5}, {6,9}};
        System.out.println("Output: " + Arrays.deepToString(result1));
        System.out.println("Expected: " + Arrays.deepToString(expected1));
        System.out.println("Test case 1 " + (Arrays.deepEquals(result1, expected1) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2
        System.out.println("Test case 2:");
        int[][] intervals2 = new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval2 = new int[]{4,8}; 
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals2) + 
                            ", newInterval = " + Arrays.toString(newInterval2));
        int[][] result2 = solution.insert(intervals2, newInterval2);
        int[][] expected2 = new int[][]{{1,2}, {3,10}, {12,16}};
        System.out.println("Output: " + Arrays.deepToString(result2));
        System.out.println("Expected: " + Arrays.deepToString(expected2));
        System.out.println("Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].");
        System.out.println("Test case 2 " + (Arrays.deepEquals(result2, expected2) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3: Insert at beginning
        System.out.println("Test case 3 (Insert at beginning):");
        int[][] intervals3 = new int[][]{{1,5}};
        int[] newInterval3 = new int[]{0,3};
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals3) + 
                            ", newInterval = " + Arrays.toString(newInterval3));
        int[][] result3 = solution.insert(intervals3, newInterval3);
        int[][] expected3 = new int[][]{{0,5}};
        System.out.println("Output: " + Arrays.deepToString(result3));
        System.out.println("Expected: " + Arrays.deepToString(expected3));
        System.out.println("Test case 3 " + (Arrays.deepEquals(result3, expected3) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: Empty intervals
        System.out.println("Test case 4 (Empty intervals):");
        int[][] intervals4 = new int[][]{};
        int[] newInterval4 = new int[]{5,7};
        System.out.println("Input: intervals = " + Arrays.deepToString(intervals4) + 
                            ", newInterval = " + Arrays.toString(newInterval4));
        int[][] result4 = solution.insert(intervals4, newInterval4);
        int[][] expected4 = new int[][]{{5,7}};
        System.out.println("Output: " + Arrays.deepToString(result4));
        System.out.println("Expected: " + Arrays.deepToString(expected4)); 
        System.out.println("Test case 4 " + (Arrays.deepEquals(result4, expected4) ? "PASSED" : "FAILED"));
    }
}
