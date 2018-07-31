package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem 47: Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermutationII {
    public List<List<Integer>> solution(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return resultList;

        Arrays.sort(nums);
        ArrayList<Integer> curList = new ArrayList<Integer>();
        boolean[] status = new boolean[nums.length];
        Arrays.fill(status, false);
        permute(nums, status, curList, resultList, 0);

        return resultList;


    }

    private void permute(int[] nums, boolean[] status, ArrayList<Integer> curList, ArrayList<List<Integer>> resultList, int count) {
        if (count == nums.length)
            resultList.add(new ArrayList(curList));

        for (int i = 0; i < nums.length; i ++) {
            if (status[i])
                continue;

            status[i] = true;
            curList.add(nums[i]);
            permute(nums, status, curList, resultList, count+1);
            status[i] = false;
            curList.remove(curList.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }

    }

    public static void main(String[] args) {
        PermutationII test = new PermutationII();
        int[] nums = new int[]{1,1,2,2};
        for (List<Integer> l : test.solution(nums))
            System.out.println(l);
    }
}
