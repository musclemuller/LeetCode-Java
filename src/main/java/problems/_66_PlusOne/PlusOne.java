package problems._66_PlusOne;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        boolean allNine = true;
        for (int i = 0; i < n; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }

        if (allNine) {
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

        int carry = 0;
        digits[n - 1] += 1; 
        for (int j = n - 1; j >= 0; j--) {
            digits[j] += carry;
            if (digits[j] >= 10) {
                carry = digits[j] / 10;
                digits[j] %= 10;
            } else {
                break;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        // Test case 1
        int[] digits1 = {1, 2, 3};
        System.out.println("Test case 1:");
        System.out.print("Input: [");
        for (int i = 0; i < digits1.length; i++) {
            System.out.print(digits1[i]);
            if (i < digits1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        int[] result1 = solution.plusOne(digits1);
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        
        // Test case 2
        int[] digits2 = {4, 3, 2, 1};
        System.out.println("\nTest case 2:");
        System.out.print("Input: [");
        for (int i = 0; i < digits2.length; i++) {
            System.out.print(digits2[i]);
            if (i < digits2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        int[] result2 = solution.plusOne(digits2);
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        
        // Test case 3
        int[] digits3 = {9};
        System.out.println("\nTest case 3:");
        System.out.print("Input: [");
        for (int i = 0; i < digits3.length; i++) {
            System.out.print(digits3[i]);
            if (i < digits3.length - 1) System.out.print(",");
        }
        System.out.println("]");
        int[] result3 = solution.plusOne(digits3);
        System.out.print("Output: [");
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i]);
            if (i < result3.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
} 