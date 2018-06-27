package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 131: Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    private List<List<String>> resultList;

    public List<List<String>> solution(String s) {
        this.resultList = new ArrayList<List<String>>();
        ArrayList<String> curList = new ArrayList<String>();
        getPalindrome(0, s, curList);
        return this.resultList;
    }

    private void getPalindrome(int start, String s, ArrayList<String> curList) {
        if (start >= s.length()){
            this.resultList.add(new ArrayList<String>(curList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i, s)) {
                curList.add(s.substring(start, i+1));
                getPalindrome(i+1, s, curList);
                curList.remove(curList.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end ,String s) {
        while  (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
