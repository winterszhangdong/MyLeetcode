package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem 90: Subsests II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> solution(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        getSets(0, nums, new ArrayList<Integer>(), resultList);
        return resultList;
    }

    private void getSets(int start, int[] nums, ArrayList<Integer> curList, ArrayList<List<Integer>> resultList) {
        resultList.add(new ArrayList<Integer>(curList));
        for (int i = start; i < nums.length; i ++) {
            curList.add(nums[i]);
            getSets(i+1, nums, curList, resultList);
            curList.remove(curList.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i+1])
                i++;
        }
    }
}
