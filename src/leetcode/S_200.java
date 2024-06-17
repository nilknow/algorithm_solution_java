package leetcode;

public class S_200 {
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int ans = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == '1') {
                        ans++;
                        dfs(grid, r, c);
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] grid, int r, int c) {
            if (!inArea(grid, r, c)) {
                return;
            }
            if (grid[r][c] == '0') {
                return;
            }
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }

        private boolean inArea(char[][] grid, int r, int c) {
            return 0 <= r && r < grid.length
                    && 0 <= c && c < grid[0].length;
        }
    }
}
