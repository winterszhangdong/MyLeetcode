package problems;

/**
 * problem 34: Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // use two binary search to find the start and end position, separately.
    public int[] solution(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0)
            return result;

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // search for the left one
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        if (nums[left] != target)
            return result;
        else
            result[0] = left;

        // search for the right one
        right = nums.length - 1;
        // we don't have to set left to 0 the second time.
        while (left < right) {
            // make mid biased to the right.
            // so that this won't make the search range stuck.(or left may always be mid)
            mid = (left + right) / 2 + 1;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        result[1] = right;

        return result;
    }
}
