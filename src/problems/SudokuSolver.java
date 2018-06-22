package problems;
import java.util.HashSet;

public class SudokuSolver {
    public HashSet[] rowSet;
    public HashSet[] colSet;
    public HashSet[][] regionSet;

    public void solution(char[][] board) {
        this.rowSet = new HashSet[9];
        this.colSet = new HashSet[9];
        this.regionSet = new HashSet[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this.regionSet[i][j] = new HashSet();

        for (int i = 0; i < 9; i++) {
            this.rowSet[i] = new HashSet();
            this.colSet[i] = new HashSet();
            for (int j = 0; j < 9; j++) {
                this.rowSet[i].add(board[i][j]);
                this.colSet[i].add(board[j][i]);
                this.regionSet[i / 3][j / 3].add(board[i][j]);
            }
        }
        this.getAns(board, 0, 0);
    }

    public boolean getAns(char[][] board, int i, int j) {
        if (i >= 9 || j >= 9)
            return true;

        while (j < 9 && board[i][j] != '.')
            j++;

        if (j == 9) {
            for (i++; i < 9; i++) {
                for (j = 0; j < 9; j++) {
                    if (board[i][j] == '.')
                        break;
                }
                if (board[i][j] == '.')
                    break;
            }
            if (i >= 9 || j >= 9)
                return true;
        }

        for (int k = 1; k < 10; k++) {
            char kc = (char) (k + '0');
            if (this.isValid(i, j, kc)) {
                this.rowSet[i].add(kc);
                this.colSet[j].add(kc);
                this.regionSet[i / 3][j / 3].add(kc);
                if (getAns(board, i + (j + 1) / 9, (j + 1) % 9)) {
                    board[i][j] = kc;
                    return true;
                } else {
                    this.rowSet[i].remove(kc);
                    this.colSet[j].remove(kc);
                    this.regionSet[i / 3][j / 3].remove(kc);
                }
            }
        }

        return false;
    }

    public boolean isValid(int i, int j, char value) {
        return (!this.rowSet[i].contains(value) && !this.colSet[j].contains(value) && !this.regionSet[i / 3][j / 3].contains(value));
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        SudokuSolver ss = new SudokuSolver();
        ss.solution(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%s ", board[i][j]);
                if (j == 8)
                    System.out.println();
            }
        }
    }
}
