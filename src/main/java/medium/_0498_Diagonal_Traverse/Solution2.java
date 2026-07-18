package medium._0498_Diagonal_Traverse;

import annotations.Explore;
import annotations.Medium;

@Medium
@Explore("Array and String")
public class Solution2 {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int diagonalCount = diagonalCount(mat);
        int[] result = new int[matCount(mat)];
        int resultIndex = 0;

        for (int diagonal = 0; diagonal < diagonalCount; diagonal++) {
            if (diagonal % 2 == 0) {
                int i = diagonal;
                int j = 0;

                while (i >= mat.length) {
                    i--;
                    j++;
                }

                while (j >= mat[i].length) {
                    i--;
                    j++;
                }

                while (i >= 0) {
                    if (j < mat[i].length) {
                        result[resultIndex++] = mat[i][j];
                    }
                    i--;
                    j++;
                }
            } else {
                int i = 0;
                int j = diagonal;

                while (i < mat.length && j >= mat[i].length) {
                    i++;
                    j--;
                }

                while (i < mat.length) {
                    if (j < 0) break;
                    if (j < mat[i].length) {
                        result[resultIndex++] = mat[i][j];
                    }
                    i++;
                    j--;
                }
            }
        }

        return result;
    }

    private int diagonalCount(int[][] mat) {
        int max = 0;

        for (int i = 0; i < mat.length; i++) {
            int currentSum = i + mat[i].length - 1;
            if (currentSum > max) {
                max = currentSum;
            }
        }

        return max + 1;
    }

    private int matCount(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i].length;
        }

        return sum;
    }
}