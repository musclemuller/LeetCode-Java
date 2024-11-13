package problems._29_DivideTwoIntegers;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) isNeg = true;
        if (x < 0) x = -x;
        if (y < 0) y = -y;
        long l = 0, r = x;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (mul(mid, y) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        long res = isNeg ? -l : l;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }

    long mul(long a, long k) {
        long res = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                res += a;
            }
            k >>= 1;
            a += a;
        }
        return res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers s = new DivideTwoIntegers();
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(7, -3));
    }
}
