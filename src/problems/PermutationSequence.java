package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * problem 60: Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    public String solution(int n, int k) {
        // factorial
        int[] fact = new int[n];
        // reduce time for removing item of nums
        List<Integer> nums = new LinkedList<Integer>();
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            nums.add(i);
            fact[i] = i * fact[i-1];
        }
        nums.add(n);
        k -= 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i-1];
            k %= fact[i-1];
            sb.append(nums.get(index));
            nums.remove(index);
        }

        return sb.toString();
    }
}
