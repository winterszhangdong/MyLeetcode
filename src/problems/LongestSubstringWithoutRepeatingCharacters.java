package problems;

import java.util.HashSet;

/**
 * problem 3: Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring..

 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int solution(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<Character>();

        for (; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                if ((right - left) > maxLen)
                    maxLen = right - left;
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(right));
            }
        }

        if ((right - left) > maxLen)
            maxLen = right - left;
        return maxLen;
    }
}
