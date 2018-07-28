package problems;

/**
 * problem 14: Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String solution(String[] strs) {
        String result = strs.length > 0 ? strs[0] : "";
        int len = result.length();
        for (String s : strs) {
            len = Math.min(len, s.length());
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) != result.charAt(i)) {
                    len = i;
                }
            }
        }

        return result.substring(0, len);
    }
}
