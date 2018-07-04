package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * problem 15: 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> solution(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            System.out.println(nums[i]);
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                if (nums[i] > 0)
                    break;
                int sum = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1])
                            l++;
                        while (l < r && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] < sum)
                        l++;
                    else
                        r--;
                }
            }
        }

        return resultList;
    }
}
