package problems._49_GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            map.computeIfAbsent(code, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (String code : map.keySet()) {
            res.add(map.get(code));
        }
        return res;
    }

    String encode(String s) {
        char[] cs = new char[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        //return cs.toString();
        return new String(cs);
    }

    public static void main(String[] args) {
        GroupAnagrams s = new GroupAnagrams();
        System.out.println(s.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(s.groupAnagrams(new String[]{""}));
        System.out.println(s.groupAnagrams(new String[]{"a"}));
    }
}
