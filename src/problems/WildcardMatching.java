package problems;

/**
 * problem 44: Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
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
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 *
 * Example 3:
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 *
 * Example 4:
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 *
 * Example 5:
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching {
    public boolean solution(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pattern = p.toCharArray();

        boolean[][] dp = new boolean[ss.length+1][pattern.length+1];
        dp[ss.length][pattern.length] = true;

        for (int i = ss.length; i >= 0; i--) {
            for (int j = pattern.length - 1; j >= 0; j--) {
                boolean firstMatch = i < ss.length && (pattern[j] == ss[i] || pattern[j] == '?');

                if (j < pattern.length && pattern[j] == '*')
                    dp[i][j] = (dp[i][j+1] || i < ss.length && dp[i+1][j]);
                else
                    dp[i][j] = (firstMatch && dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}
