package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winters on 2018/7/14.
 */
public class GroupAnagrams {
    public List<List<String>> solution(String[] strs) {
        ArrayList<List<String>> resultList = new ArrayList<List<String>>();
        ArrayList<Integer[]> countsList = new ArrayList<Integer[]>();
//        int[][] counts = new int[strs.length][26];
        for (String s : strs) {
            for (char c : s.toCharArray()) {
                int[] counts = new int[26];
                int index = c - 'a';
                counts[index]++;
            }

            for (int i = 0; i < countsList.size(); i++) {
                if (s.length() == resultList.get(i).get(0).length()) {
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) != countsList.get(i)[j]) {

                        }
                    }
                }
            }
        }
    }
}
