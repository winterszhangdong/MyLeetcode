package problems;

import java.util.Stack;
/**
 * Created by winters on 2018/7/9.
 */
public class MaximalRectangle {
    public int solution(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int[] h = new int[matrix[0].length];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (char[] row : matrix) {
            for (int i = 0; i < h.length; i++) {
                if (row[i] == '1')
                    h[i]++;
                else
                    h[i] = 0;
            }

            for (int i = 0; i < h.length; i++) {
                if (h[i] != 0 && ((stack.isEmpty() || h[i] <= stack.peek()))) {
                    stack.push(h[i]);
                } else if (h[i] != 0) {
                    maxArea = Math.max(maxArea, stack.peek() * stack.size());
                    while (!stack.isEmpty())
                        stack.pop();
                    if (h[i] != 0)
                        stack.push(h[i]);
                } else if (h[i] == 0 && !stack.isEmpty()) {
                    maxArea = Math.max(maxArea, stack.peek() * stack.size());
                    while (!stack.isEmpty())
                        stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                maxArea = Math.max(maxArea, stack.peek() * stack.size());
                while (!stack.isEmpty())
                    stack.pop();
            }

        }

        return maxArea;
    }
}
