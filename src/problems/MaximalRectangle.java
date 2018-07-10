package problems;

import java.util.Stack;
/**
 * problem 85: Maximal Rectangle
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public int solution(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int[] h = new int[matrix[0].length];
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < h.length; i++) {
                if (row[i] == '1')
                    h[i]++;
                else
                    h[i] = 0;
            }

            for (int i = 0; i <= h.length; i++) {
                while (!stack.isEmpty() && (i == h.length || h[i] < h[stack.peek()])) {
                    int height = h[stack.pop()];
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height*width);
                }
                if (i != h.length)
                    stack.push(i);
            }
        }

        return maxArea;
    }
}
