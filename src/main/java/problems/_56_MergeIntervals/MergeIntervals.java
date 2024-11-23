package problems._56_MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] last = list.getLast();
            if (cur[0] > last[1]) {
                list.add(cur);
            } else {
                last[1] = Math.max(last[1], cur[1]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        
        // Test case 1
        System.out.println("Test case 1:");
        int[][] input1 = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println("Input: intervals = " + Arrays.deepToString(input1));
        int[][] result1 = solution.merge(input1);
        int[][] expected1 = new int[][]{{1,6}, {8,10}, {15,18}};
        System.out.println("Output: " + Arrays.deepToString(result1));
        System.out.println("Expected: " + Arrays.deepToString(expected1));
        System.out.println("Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].");
        System.out.println("Test case 1 " + (Arrays.deepEquals(result1, expected1) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2
        System.out.println("Test case 2:");
        int[][] input2 = new int[][]{{1,4}, {4,5}};
        System.out.println("Input: intervals = " + Arrays.deepToString(input2));
        int[][] result2 = solution.merge(input2);
        int[][] expected2 = new int[][]{{1,5}};
        System.out.println("Output: " + Arrays.deepToString(result2));
        System.out.println("Expected: " + Arrays.deepToString(expected2));
        System.out.println("Explanation: Intervals [1,4] and [4,5] are considered overlapping.");
        System.out.println("Test case 2 " + (Arrays.deepEquals(result2, expected2) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3: Single interval
        System.out.println("Test case 3 (Single interval):");
        int[][] input3 = new int[][]{{1,1}};
        System.out.println("Input: intervals = " + Arrays.deepToString(input3));
        int[][] result3 = solution.merge(input3);
        int[][] expected3 = new int[][]{{1,1}};
        System.out.println("Output: " + Arrays.deepToString(result3));
        System.out.println("Expected: " + Arrays.deepToString(expected3));
        System.out.println("Test case 3 " + (Arrays.deepEquals(result3, expected3) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: Empty intervals
        System.out.println("Test case 4 (Empty intervals):");
        int[][] input4 = new int[][]{};
        System.out.println("Input: intervals = " + Arrays.deepToString(input4));
        int[][] result4 = solution.merge(input4);
        int[][] expected4 = new int[][]{};
        System.out.println("Output: " + Arrays.deepToString(result4));
        System.out.println("Expected: " + Arrays.deepToString(expected4));
        System.out.println("Test case 4 " + (Arrays.deepEquals(result4, expected4) ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 5: Multiple overlapping intervals
        System.out.println("Test case 5 (Multiple overlapping intervals):");
        int[][] input5 = new int[][]{{1,4}, {2,3}, {3,6}, {5,7}, {6,8}};
        System.out.println("Input: intervals = " + Arrays.deepToString(input5));
        int[][] result5 = solution.merge(input5);
        int[][] expected5 = new int[][]{{1,8}};
        System.out.println("Output: " + Arrays.deepToString(result5));
        System.out.println("Expected: " + Arrays.deepToString(expected5));
        System.out.println("Test case 5 " + (Arrays.deepEquals(result5, expected5) ? "PASSED" : "FAILED"));
    }
}
