package problems._58_LengthOfLastWord;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(j) == ' ') {
                j--;
            } else {
                break;
            }
        }

        int i = j;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                break;
            }
            i--;
        }

        return j - i;
    }

    public static void main(String[] args) {
        LengthOfLastWord solution = new LengthOfLastWord();
        
        // Test case 1
        System.out.println("Test case 1:");
        String s1 = "Hello World";
        System.out.println("Input: s = \"" + s1 + "\"");
        int result1 = solution.lengthOfLastWord(s1);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 5");
        System.out.println("Explanation: The last word is \"World\" with length 5.");
        System.out.println("Test case 1 " + (result1 == 5 ? "PASSED" : "FAILED"));
        System.out.println();
     
        // Test case 2
        System.out.println("Test case 2:");
        String s2 = "   fly me   to   the moon  ";
        System.out.println("Input: s = \"" + s2 + "\"");
        int result2 = solution.lengthOfLastWord(s2);
        System.out.println("Output: " + result2);
        System.out.println("Expected: 4");
        System.out.println("Explanation: The last word is \"moon\" with length 4.");
        System.out.println("Test case 2 " + (result2 == 4 ? "PASSED" : "FAILED"));
        System.out.println();
     
        // Test case 3
        System.out.println("Test case 3:");
        String s3 = "luffy is still joyboy";
        System.out.println("Input: s = \"" + s3 + "\"");
        int result3 = solution.lengthOfLastWord(s3);
        System.out.println("Output: " + result3);
        System.out.println("Expected: 6");
        System.out.println("Explanation: The last word is \"joyboy\" with length 6.");
        System.out.println("Test case 3 " + (result3 == 6 ? "PASSED" : "FAILED"));
        System.out.println();
     
        // Test case 4: Single word
        System.out.println("Test case 4 (Single word):");
        String s4 = "hello";
        System.out.println("Input: s = \"" + s4 + "\"");
        int result4 = solution.lengthOfLastWord(s4);
        System.out.println("Output: " + result4);
        System.out.println("Expected: 5");
        System.out.println("Test case 4 " + (result4 == 5 ? "PASSED" : "FAILED"));
        System.out.println();
     
        // Test case 5: Multiple spaces between words
        System.out.println("Test case 5 (Multiple spaces between words):");
        String s5 = "   hello     world    ";
        System.out.println("Input: s = \"" + s5 + "\"");
        int result5 = solution.lengthOfLastWord(s5);
        System.out.println("Output: " + result5);
        System.out.println("Expected: 5");
        System.out.println("Test case 5 " + (result5 == 5 ? "PASSED" : "FAILED"));
     }
}
