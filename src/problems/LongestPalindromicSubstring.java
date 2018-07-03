package problems;

/**
 * problem 5: Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String solution(String s) {
        if (s.length() == 0)
            return "";

        int start = 0;
        int maxLen = 1;
        int curLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                curLen = getLongestLen(s, i, i+1);
                if ((curLen * 2 + 2) > maxLen) {
                    maxLen = curLen * 2 + 2;
                    start = i - curLen;
                }
            }
            if (i+2 < s.length() && s.charAt(i) == s.charAt(i+2)) {
                curLen = getLongestLen(s, i, i+2);
                if ((curLen * 2 + 3) > maxLen) {
                    maxLen = curLen * 2 + 3;
                    start = i - curLen;
                }
            }
        }

        return s.substring(start, start+maxLen);
    }

    private int getLongestLen(String s, int axisLeft, int axisRight) {
        int len = 0;
        for (int i = axisLeft - 1, j = axisRight + 1; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) == s.charAt(j))
                len++;
            else
                break;
        }

        return len;
    }
}
