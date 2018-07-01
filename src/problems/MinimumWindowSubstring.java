package problems;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * problem 76: Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashSet<Character> targetSet = new HashSet<Character>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        int minLen = s.length();
        int stopPos = minLen - t.length();
        int start = 0;

        for (int i = 0; i < t.length(); i++) {
            targetSet.add(t.charAt(i));
        }

        for (int i = 0; i < s.length(); i++)
            if (targetSet.contains(s.charAt(i)))
                indexList.add(i);
        if (indexList.isEmpty())
            return "";

        int i = 0;
        int j = 1;
        int len;
        char leftChar;
        char rightChar;
        targetSet.remove(s.charAt(indexList.get(0)));
        while (indexList.get(i) <= stopPos) {
            leftChar = s.charAt(indexList.get(i++));
            while (!targetSet.isEmpty() && j < indexList.size()) {
                rightChar = s.charAt(indexList.get(j++));
                if (targetSet.contains(rightChar))
                    targetSet.remove(rightChar);
                else
                if (leftChar == rightChar)
                    leftChar = s.charAt(indexList.get(i++));
            }
            len = indexList.get(j-1) - indexList.get(i-1) + 1;
            if (len < minLen) {
                minLen = len;
                start = indexList.get(i-1);
            }
            if (j >= indexList.size())
                break;
            targetSet.add(leftChar);
        }

        return s.substring(start, start + minLen);
    }
}
