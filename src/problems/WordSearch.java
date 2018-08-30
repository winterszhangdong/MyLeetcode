package problems;

/**
 * problem 79: Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean solution(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        else if (board.length == 0)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(board, word, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean find (char[][] board, String word, int cur, int i, int j) {
        if (cur == word.length())
            return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || word.charAt(cur) != board[i][j])
            return false;
        char tmp = board[i][j];
        board[i][j] = '%';

        boolean exist = find(board, word, cur+1, i-1, j) ||
                find(board, word, cur+1, i+1, j) ||
                find(board, word, cur+1, i, j-1) ||
                find(board, word, cur+1, i, j+1);

        board[i][j] = tmp;
        return exist;
    }
}
