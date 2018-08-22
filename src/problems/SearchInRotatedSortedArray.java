package problems;

/**
 * problem 33: Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise * return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || (target > nums[len-1] && target < nums[0]))
            return -1;

        int left = 0;
        int right = len - 1;
        // find the pivot
        // when left == right, pivot is left
        if (nums[left] > nums[right]) {
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right])
                    left = mid + 1;
                else
                    right = mid;
            }
        }

        // determine the target on the left of the pivot or on the right of the pivot
        int pivot = left;
        if (pivot != 0 && target >= nums[0] && target <= nums[pivot-1]) {
            left = 0;
            right = pivot;
        } else {
            left = pivot;
            right = len - 1;
        }

        // binary search
        while (left <= right) {
            int mid = (left + right) /2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
