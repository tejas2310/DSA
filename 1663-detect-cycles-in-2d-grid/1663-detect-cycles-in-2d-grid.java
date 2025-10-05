import java.util.*;

class Solution {
    static int[][] isVisited;
    static char[][] grid;

    public static boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Solution.grid = grid;
        isVisited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isVisited[i][j] == 0) {
                    if (dfs(i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(int row, int col, int prevRow, int prevCol) {
        isVisited[row][col] = 1;
        char value = grid[row][col];
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Out of bounds
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length)
                continue;

            // Skip previous cell
            if (newRow == prevRow && newCol == prevCol)
                continue;

            // Only consider same character
            if (grid[newRow][newCol] != value)
                continue;

            // If already visited, and it's not the parent, we found a cycle
            if (isVisited[newRow][newCol] == 1)
                return true;

            // DFS for unvisited node
            if (dfs(newRow, newCol, row, col))
                return true;
        }

        return false;
    }
}