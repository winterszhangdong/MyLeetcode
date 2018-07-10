package problems;

import java.util.Stack;

/**
 * problem 84: Largest Rectangle in Histogram
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectangleInHistogram {
    public int solution(int[] heights) {
        if (heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int h;
        int w;
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                h = heights[stack.pop()];
                w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
            stack.push(i);
        }

        return max;
    }
}
