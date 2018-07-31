package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 39: Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> curList = new ArrayList<Integer>();
        combine(list, curList, candidates, 0, target);
        return list;
    }

    public void combine(List<List<Integer>> list, List<Integer> curList, int[] candidates, int start, int rest) {
        if (rest == 0)
            list.add(new ArrayList<Integer>(curList));
        else if (rest < 0){
            for (int i = start; i < candidates.length; i++) {
                curList.add(candidates[i]);
                combine(list, curList, candidates, i, rest - candidates[i]);
                curList.remove(curList.size() - 1);
            }
        }
    }
}
