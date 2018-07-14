package problems;

/**
 * problem 200: Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    public int solution(char[][] grid) {
        if (grid.length == 0)
            return 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    visitIsland(grid, isVisited, i, j);
                    num++;
                }
            }
        }

        return num;
    }

    private void visitIsland(char[][] grid, boolean[][] isVisited, int i, int j) {
        if (grid[i][j] == '1') {
            isVisited[i][j] = true;
            if (i - 1 >= 0 && !isVisited[i-1][j])
                visitIsland(grid, isVisited, i - 1, j);
            if (i + 1 < grid.length && !isVisited[i+1][j])
                visitIsland(grid, isVisited, i + 1, j);
            if (j - 1 >= 0 && !isVisited[i][j-1])
                visitIsland(grid, isVisited, i, j - 1);
            if (j + 1 < grid[0].length && !isVisited[i][j+1])
                visitIsland(grid, isVisited, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid2 = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        NumberOfIslands test = new NumberOfIslands();
        System.out.println(test.solution(grid2));
    }
}
