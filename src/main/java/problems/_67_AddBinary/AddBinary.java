package problems._67_AddBinary;

public class AddBinary {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();

        int m = a.length(), n = b.length();
        int carry = 0;
        int i = 0;

        while (i < Math.max(m, n) || carry > 0) {
            int val = carry;
            val += i < m ? (a.charAt(i) - '0') : 0;
            val += i < n ? (b.charAt(i) - '0') : 0;
            sb.append(val % 2);
            carry = val / 2;
            i++;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        
        // Test case 1
        String a1 = "11";
        String b1 = "1";
        System.out.println("Test case 1:");
        System.out.println("Input: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a1, b1) + "\"");
        
        // Test case 2 
        String a2 = "1010";
        String b2 = "1011";
        System.out.println("\nTest case 2:");
        System.out.println("Input: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a2, b2) + "\"");
    }
} 