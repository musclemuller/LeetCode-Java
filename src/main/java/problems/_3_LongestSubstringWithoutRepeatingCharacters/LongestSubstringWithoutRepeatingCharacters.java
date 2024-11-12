package problems._3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            r++;
            charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
            while (charToFreq.get(c) > 1) {
                char del = s.charAt(l);
                l++;
                charToFreq.put(del, charToFreq.get(del) - 1);
                //charToFreq.remove(del);
            }
            res = Math.max(res, r - l);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String teString = "abcabcbb";
        System.out.println(s.lengthOfLongestSubstring(teString));
    }
}
