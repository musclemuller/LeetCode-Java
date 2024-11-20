package problems._42_TrappingRainWater;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TrappingRainWater s = new TrappingRainWater();
        int[] height1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = new int[]{4,2,0,3,2,5};

        System.out.println(s.trap(height1));
        System.out.println(s.trap(height2));
    }
}
