package problems;

import java.util.HashSet;

/**
 * problem 128: Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int n : nums)
            set.add(n);

        while (!set.isEmpty()) {
            int n = set.iterator().next();
            int tmp = n;
            int count = 0;
            while (set.remove(tmp++))
                count++;
            tmp = n - 1;
            while (set.remove(tmp--))
                count++;
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main (String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();
        int[] nums = new int[]{100};
        System.out.println(test.solution(nums));
    }
}
