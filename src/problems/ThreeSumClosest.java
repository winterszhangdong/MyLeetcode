package problems;

import java.util.Arrays;

/**
 * problem 19: 3Sum Closest
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int result = target;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r] - target;
                if (tmp == 0) {
                    return target;
                } else if (Math.abs(tmp) <= gap) {
                    gap = Math.abs(tmp);
                    result = nums[i] + nums[l] + nums[r];
                }
                if (tmp > 0)
                    r--;
                else
                    l++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = new int[]{-1,-5,1,0,6,7};
        System.out.println(test.solution(nums, 0));
    }
}
