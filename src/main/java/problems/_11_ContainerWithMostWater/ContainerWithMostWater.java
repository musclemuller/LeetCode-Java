package problems._11_ContainerWithMostWater;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int cur = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater s = new ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }
}
