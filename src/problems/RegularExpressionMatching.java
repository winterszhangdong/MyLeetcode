package problems;

/**
 * problem 10: Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching {
    public boolean solution(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pattern = p.toCharArray();

        return match(ss, 0, pattern, 0);
    }

    private boolean match(char[] ss, int i, char[] pattern, int j) {
        if (j >= pattern.length)
            return i >= ss.length;

        boolean firstMatch = (i < ss.length && (pattern[j] == ss[i] || pattern[j] == '.'));
        if (j <= pattern.length - 2 && pattern[j+1] == '*')
            return (match(ss, i, pattern, j+2) || (firstMatch && match(ss, i+1, pattern, j)));
        else
            return firstMatch && match(ss, i+1, pattern, j+1);
    }
}
