package problems._60_PermutationSequence;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        return "";
    }
    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        
        // Test case 1
        System.out.println("Test case 1:");
        int n1 = 3, k1 = 3;
        System.out.println("Input: n = " + n1 + ", k = " + k1);
        String result1 = solution.getPermutation(n1, k1);
        System.out.println("Output: \"" + result1 + "\"");
        System.out.println("Expected: \"213\""); 
        System.out.println("Test case 1 " + (result1.equals("213") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 2
        System.out.println("Test case 2:"); 
        int n2 = 4, k2 = 9;
        System.out.println("Input: n = " + n2 + ", k = " + k2);
        String result2 = solution.getPermutation(n2, k2);
        System.out.println("Output: \"" + result2 + "\"");
        System.out.println("Expected: \"2314\"");
        System.out.println("Test case 2 " + (result2.equals("2314") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 3
        System.out.println("Test case 3:");
        int n3 = 3, k3 = 1; 
        System.out.println("Input: n = " + n3 + ", k = " + k3);
        String result3 = solution.getPermutation(n3, k3);
        System.out.println("Output: \"" + result3 + "\"");
        System.out.println("Expected: \"123\"");
        System.out.println("Test case 3 " + (result3.equals("123") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 4: n = 1
        System.out.println("Test case 4:");
        int n4 = 1, k4 = 1;
        System.out.println("Input: n = " + n4 + ", k = " + k4);
        String result4 = solution.getPermutation(n4, k4);
        System.out.println("Output: \"" + result4 + "\"");
        System.out.println("Expected: \"1\"");
        System.out.println("Test case 4 " + (result4.equals("1") ? "PASSED" : "FAILED"));
        System.out.println();
        
        // Test case 5: Maximum case
        System.out.println("Test case 5:");
        int n5 = 9, k5 = 362880; // 9! = 362880
        System.out.println("Input: n = " + n5 + ", k = " + k5);
        String result5 = solution.getPermutation(n5, k5);
        System.out.println("Output: \"" + result5 + "\"");
        System.out.println("Expected: \"987654321\"");
        System.out.println("Test case 5 " + (result5.equals("987654321") ? "PASSED" : "FAILED"));
     }
}
