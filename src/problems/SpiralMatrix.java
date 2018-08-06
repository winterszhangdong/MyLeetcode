package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * problem 54: Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> solution(int[][] matrix) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (matrix.length == 0)
            return resultList;
        int left  = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int size = matrix.length * matrix[0].length;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++)
                resultList.add(matrix[up][i]);

            for (int i = up + 1; i <= down; i++)
                resultList.add(matrix[i][right]);

            for (int i = right - 1; i >= left && resultList.size() != size; i--)
                resultList.add(matrix[down][i]);

            for (int i = down - 1; i > up && resultList.size() != size; i--)
                resultList.add(matrix[i][left]);

            left++;
            right--;
            up++;
            down--;
        }

        return resultList;
    }
}
