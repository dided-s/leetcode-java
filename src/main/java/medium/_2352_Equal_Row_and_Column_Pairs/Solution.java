package medium._2352_Equal_Row_and_Column_Pairs;

import annotations.LeetCode75;
import annotations.Medium;

import java.util.HashMap;
import java.util.Map;

@Medium
@LeetCode75("Hash Map / Set")
public class Solution {

    public int equalPairs(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < n; j++) {
                num.append(grid[i][j]);
                num.append(" ");
            }
            String key = num.toString();
            if (!map.containsKey(key)) {
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
        }

        for (int i = 0; i < n; i++) {
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < n; j++) {
                num.append(grid[j][i]);
                num.append(" ");
            }
            if (map.containsKey(num.toString())) {
                answer += map.get(num.toString());
            }
        }

        return answer;
    }
}