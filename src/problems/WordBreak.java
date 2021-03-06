package problems;

import java.util.HashSet;
import java.util.List;

/**
 * problem 139: Word Break
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
    public boolean solution(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>();
        dict.addAll(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 1; i<= s.length(); i++) {
            for (int j = i - 1; j>= 0; j--) {
                dp[i] = dp[j] && dict.contains(s.substring(j, i));
                if (dp[i])
                    break;
            }
        }

        return dp[s.length()];
    }
}
