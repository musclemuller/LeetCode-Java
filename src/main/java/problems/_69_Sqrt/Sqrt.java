package problems._69_Sqrt;

public class Sqrt {
    public int mySqrt(int x) {
        int l = 0, r = x, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Sqrt solution = new Sqrt();
        
        // Test case 1
        int x1 = 4;
        System.out.println("Test case 1:");
        System.out.println("Input: x = " + x1);
        System.out.println("Output: " + solution.mySqrt(x1));
        
        // Test case 2
        int x2 = 8;
        System.out.println("\nTest case 2:");
        System.out.println("Input: x = " + x2); 
        System.out.println("Output: " + solution.mySqrt(x2));
        System.out.println("Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.");
    }
} 