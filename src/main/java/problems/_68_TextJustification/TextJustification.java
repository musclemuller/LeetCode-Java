package problems._68_TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int right = 0, n = words.length;
        while (true) {
            int left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            if (right == n) {
                StringBuffer sb = join(words, left, n, " ");
                sb.append(blank(maxWidth - sb.length()));
                res.add(sb.toString());
                return res;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                res.add(sb.toString());
                continue;
            }

            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces)));
            res.add(sb.toString());

        }
    }

    String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; i++) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        
        // Test case 1
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println("Test case 1:");
        System.out.println("Input: words = [\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"], maxWidth = " + maxWidth1);
        System.out.println("Output:");
        List<String> result1 = solution.fullJustify(words1, maxWidth1);
        System.out.println("[");
        for (String line : result1) {
            System.out.println("   \"" + line + "\"");
        }
        System.out.println("]");

        // Test case 2
        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth2 = 16;
        System.out.println("\nTest case 2:");
        System.out.println("Input: words = [\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"], maxWidth = " + maxWidth2);
        System.out.println("Output:");
        List<String> result2 = solution.fullJustify(words2, maxWidth2);
        System.out.println("[");
        for (String line : result2) {
            System.out.println("   \"" + line + "\"");
        }
        System.out.println("]");

        // Test case 3
        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth3 = 20;
        System.out.println("\nTest case 3:");
        System.out.println("Input: words = [\"Science\",\"is\",\"what\",\"we\",\"understand\",\"well\",\"enough\",\"to\",\"explain\",\"to\",\"a\",\"computer.\",\"Art\",\"is\",\"everything\",\"else\",\"we\",\"do\"], maxWidth = " + maxWidth3);
        System.out.println("Output:");
        List<String> result3 = solution.fullJustify(words3, maxWidth3);
        System.out.println("[");
        for (String line : result3) {
            System.out.println("   \"" + line + "\"");
        }
        System.out.println("]");
    }
} 