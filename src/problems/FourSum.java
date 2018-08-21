package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * problem 18: 4 Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 4)
            return res;

        Arrays.sort(nums);
        // target is too small or too larget
        if (4 * nums[0] > target || 4 * nums[len-1] < target)
            return res;

        for (int i = 0; i < len - 3; i++) {
            // avoid duplicate
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            // nums[i] is too small
            if (nums[i]+nums[len-1]+nums[len-2]+nums[len-3] < target)
                continue;
            // nums[i] is too large
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target)
                continue;
            // nums[i] is the boundary
            if (nums[i] * 4 == target) {
                if (nums[i+3] == nums[i])
                    res.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                break;
            }

            threeSum(nums, i+1, nums[i], res, target-nums[i]);
        }

        return res;
    }

    // Use the solution of problem: 3Sum
    private void threeSum(int[] nums, int start, int selected, List<List<Integer>> res, int target) {
        for (int i = start; i < nums.length - 2; i++) {
            if (i == start || (i > 0 && nums[i] != nums[i-1])) {
                int rest = target - nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == rest) {
                        res.add(Arrays.asList(selected, nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1])
                            l++;
                        while (l < r && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    }
                    else if (nums[l] + nums[r] < rest)
                        l++;
                    else
                        r--;
                }
            }
        }
    }
}
