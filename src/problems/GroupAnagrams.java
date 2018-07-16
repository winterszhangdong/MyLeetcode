package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * problem 49: Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                counts[index]++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int n : counts) {
                sb.append("#");
                sb.append(n);
            }

            String converted = sb.toString();
            if (!map.containsKey(converted))
                map.put(converted, new ArrayList<String>());
            map.get(converted).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = new String[]{};
        for (List<String> list : test.solution((strs2)))
            System.out.println(list);
    }
}
