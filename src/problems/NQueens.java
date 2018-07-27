package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

/**
 * problem 51: N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    private HashSet<Integer> rowSet;
    private HashSet<Integer> colSet;
    private HashSet<Integer> diagonalLeftSet;
    private HashSet<Integer> diagonalRightSet;

    public List<List<String>> solution(int n) {
        rowSet = new HashSet<Integer>();
        colSet = new HashSet<Integer>();
        diagonalLeftSet = new HashSet<Integer>();
        diagonalRightSet = new HashSet<Integer>();
        int[][] curPos = new int[n][2];
        ArrayList<List<String>> resultList = new ArrayList<List<String>>();

        if (n == 0) {
            resultList.add(new ArrayList<String>());
            return resultList;
        }


        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (validate(i, j)) {
                    curPos[index][0] = i;
                    curPos[index][1] = j;
                    index++;
                    if (index == n) {
                        resultList.add(convert(curPos, n));
                        index--;
                        if (index > 0 && i == n - 1 && j == n - 1) {
                            index--;
                            i = curPos[index][0];
                            j = curPos[index][1];
                            rowSet.remove(i);
                            colSet.remove(j);
                            diagonalLeftSet.remove(i-j);
                            diagonalRightSet.remove(i+j);
                        }
                    } else {
                        rowSet.add(i);
                        colSet.add(j);
                        diagonalLeftSet.add(i-j);
                        diagonalRightSet.add(i+j);
                        j = n;
                    }
                } else if (j == n - 1) {
                    while (j == n - 1) {
                        index--;
                        if (index == -1)
                            return resultList;
                        i = curPos[index][0];
                        j = curPos[index][1];
                        rowSet.remove(i);
                        colSet.remove(j);
                        diagonalLeftSet.remove(i-j);
                        diagonalRightSet.remove(i+j);
                    }
                }
            }
        }

        return resultList;
    }

    private List<String> convert(int[][] curPos, int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
            int x = curPos[i][0];
            int y = curPos[i][1];
            board[x][y] = 'Q';
        }

        for (int i = 0; i < n; i++)
            result.add(String.valueOf(board[i]));

        return result;
    }

    private boolean validate(int i, int j) {
        return !rowSet.contains(i) && !colSet.contains(j) && !diagonalLeftSet.contains(i - j) && !diagonalRightSet.contains(i + j);
    }

}
