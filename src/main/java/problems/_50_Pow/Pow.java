package problems._50_Pow;

public class Pow {
    public double myPow(double x, int n) {
        if (x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Pow s = new Pow();
        System.out.printf("%.5f%n", s.myPow(2.00000, 10));
        System.out.printf("%.5f%n", s.myPow(2.10000, 3));
        System.out.printf("%.5f%n", s.myPow(2.00000, -2));
    }
}
