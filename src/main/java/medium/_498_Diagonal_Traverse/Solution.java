package medium._498_Diagonal_Traverse;

import annotations.Explore;
import annotations.Medium;

import java.util.*;

@Medium
@Explore("Array and String")
public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        Map<Integer, Deque<Integer>> groups = new HashMap<>();

        int n = 0;
        for (int row = mat.length - 1; row >= 0; row--) {
            for (int col = 0; col < mat[row].length; col++) {
                int diagonal = row + col;
                if (!groups.containsKey(diagonal)) {
                    groups.put(diagonal, new ArrayDeque<>());
                }

                groups.get(diagonal).add(mat[row][col]);
                n++;
            }
        }

        int[] ans = new int[n];
        int i = 0;
        int diagonal = 0;

        while (groups.containsKey(diagonal)) {
            if (diagonal % 2 == 0) {
                for (Iterator<Integer> it = groups.get(diagonal).iterator(); it.hasNext(); ) {
                    int num = it.next();
                    ans[i++] = num;
                }
            } else {
                for (Iterator<Integer> it = groups.get(diagonal).descendingIterator(); it.hasNext(); ) {
                    int num = it.next();
                    ans[i++] = num;
                }
            }

            diagonal++;
        }

        return ans;
    }
}