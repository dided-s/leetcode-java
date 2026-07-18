package medium._0054_Spiral_Matrix;

import annotations.Explore;
import annotations.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Medium
@Explore("Array and String")
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }

        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> result = new ArrayList<>(n * m);
        int resultIndex = 0;

        int i = 0;
        int j = -1;

        boolean toRight = true;
        boolean toLeft = false;
        boolean toUp = false;
        boolean toBottom = false;

        int rightBorder = m - 1;
        int leftBorder = 0;
        int upBorder = 1;
        int bottomBorder = n - 1;

        while (resultIndex < n * m) {
            if (toRight) {
                if (j == rightBorder) {
                    toRight = false;
                    toBottom = true;
                    rightBorder--;
                    continue;
                } else {
                    j++;
                }
            } else if (toBottom) {
                if (i == bottomBorder) {
                    toBottom = false;
                    toLeft = true;
                    bottomBorder--;
                    continue;
                } else {
                    i++;
                }
            } else if (toLeft) {
                if (j == leftBorder) {
                    toLeft = false;
                    toUp = true;
                    leftBorder++;
                    continue;
                } else {
                    j--;
                }
            } else if (toUp) {
                if (i == upBorder) {
                    toUp = false;
                    toRight = true;
                    upBorder++;
                    continue;
                } else {
                    i--;
                }
            }

            result.add(matrix[i][j]);
            resultIndex++;
        }

        return result;
    }
}