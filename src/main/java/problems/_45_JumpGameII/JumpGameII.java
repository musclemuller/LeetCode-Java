package problems._45_JumpGameII;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII s = new JumpGameII();
        System.out.println(s.jump(new int[]{2,3,1,1,4}));
        System.out.println(s.jump(new int[]{2,3,0,1,4}));
    }
}
