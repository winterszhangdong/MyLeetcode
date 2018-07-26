package problems;

/**
 * problem 28: Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementStrStr {
    public int solution(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);

        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p.length)
            return i - j;
        else
            return -1;
    }

    private int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int i = 0;
        int j = -1;

        while (i < p.length - 1) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        return next;
    }
}
