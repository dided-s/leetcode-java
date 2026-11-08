package medium._1267_Count_Servers_that_Communicate;

import annotations.Medium;

@Medium
class Solution {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    answer += (rows[i] > 1 || cols[j] > 1) ? 1 : 0;
                }
            }
        }

        return answer;
    }
}