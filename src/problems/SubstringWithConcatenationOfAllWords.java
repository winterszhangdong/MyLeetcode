package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * problem 20: Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 *
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 * Input:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 *
 * Output: []
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> solution(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int sLen = s.length();
        int wCount = words.length;
        if (sLen == 0 || wCount == 0 || sLen < wCount * words[0].length())
            return res;

        // first hashmap stores the count of word in the word list.
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            int count = map.containsKey(word) ? map.get(word) + 1 : 1;
            map.put(word, count);
        }

        int wLen = words[0].length();
        for (int i = 0; i < wLen; i++) {
            int count = 0;
            // second hashmap stores count of word in the string s.
            HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
            for (int j = i; j <= sLen - wLen; j += wLen) {
                String word = s.substring(j, j+wLen);
                if (map.containsKey(word)) {
                    if (tmpMap.containsKey(word))
                        tmpMap.put(word, tmpMap.get(word)+1);
                    else
                        tmpMap.put(word, 1);

                    // if counts of the word in string s appears more than counts of word in the word list.
                    if (tmpMap.get(word) > map.get(word)) {
                        int start = j - count * wLen;
                        String w = "";
                        // delete the word from tmpMap until the duplicate one found.
                        while (!w.equals(word)) {
                            w = s.substring(start, start+wLen);
                            tmpMap.put(w, tmpMap.get(w)-1);
                            start += wLen;
                            count--;
                        }
                    }
                    count++;
                    // concatenation found.
                    if (count == wCount) {
                        int start = j - (count - 1) * wLen;
                        String w = s.substring(start, start+wLen);
                        res.add(start);
                        tmpMap.put(w, tmpMap.get(w)-1);
                        count--;
                    }
                } else {
                    // the word in string s is not existed in word list.
                    tmpMap.clear();
                    count = 0;
                }
            }
        }

        return res;
    }
}
