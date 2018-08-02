package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 78: Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> solution(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        resultList.add(new ArrayList<Integer>());
        getSets(0,nums, new ArrayList<Integer>(), resultList);
        return resultList;
    }

    private void getSets(int start, int[] nums, ArrayList<Integer> curList, ArrayList<List<Integer>> resultList) {
        for (int i = start; i < nums.length; i++) {
            curList.add(nums[i]);
            resultList.add(new ArrayList<Integer>(curList));
            getSets(i+1, nums, curList, resultList);
            curList.remove(curList.size() - 1);
        }
    }
}
