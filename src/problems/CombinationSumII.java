package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem 40: Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {
    public List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        combine(resultList, curList, candidates, 0, target);
        return resultList;
    }

    private void combine(List<List<Integer>> resultList, List<Integer> curList, int[] candidates, int start, int rest) {
        if (rest < 0)
            return;
        else if (rest == 0)
            resultList.add(new ArrayList<Integer>(curList));
        else {
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                combine(resultList, curList, candidates, i+1, rest-candidates[i]);
                curList.remove(curList.size()-1);
                while (i < candidates.length - 1 && candidates[i] == candidates[i+1])
                    i++;
            }
        }
    }
}
