package problems._17_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
    Map<Character, Set<Character>> map;
    List<String> res;
    char[] dc;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        map = new HashMap<>();
        map.put('2', new HashSet<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new HashSet<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new HashSet<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new HashSet<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new HashSet<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new HashSet<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new HashSet<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new HashSet<>(Arrays.asList('w', 'x', 'y', 'z')));
        dc = digits.toCharArray();
        traverse(0, new StringBuilder());
        return res;
    }

    void traverse(int i, StringBuilder sb) {
        if (i == dc.length) {
            res.add(sb.toString());
            return;
        }

        for (char c : map.get(dc[i])) {
            sb.append(c);
            traverse(i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
        System.out.println(s.letterCombinations("23"));
        System.out.println(s.letterCombinations(""));
        System.out.println(s.letterCombinations("2"));
    }
}
