package problems._28_FindTheIndexOfTheFirstOccurrenceInAString;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;
        for (int i = 0; i <= (m - n); i++) {
            if (needle.equals(haystack.substring(i, i + n))) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString s = new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(s.strStr("sadbutsad", "sad"));
        System.out.println(s.strStr("leetcode", "leeto"));
    }
}
