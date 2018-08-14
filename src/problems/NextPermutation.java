package problems;

import java.util.Arrays;

/**
 * problem 31: Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void solution(int[] nums) {
        if (nums.length <= 1)
            return;

        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i-1])
            i--;

        if (i == 0) {
            Arrays.sort(nums);
            return;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i-1] && i <= j)
            j--;

        nums[i-1] = nums[i-1] ^ nums[j];
        nums[j] = nums[j] ^ nums[i-1];
        nums[i-1] = nums[j] ^ nums[i-1];

        Arrays.sort(nums, i, nums.length);
    }
}
