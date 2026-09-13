package medium._0835_Image_Overlap;

import annotations.Medium;

@Medium
public class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int res = 0;

        int[][] ones1 = new int[n * n][2];
        int size1 = 0;

        int[][] ones2 = new int[n * n][2];
        int size2 = 0;

        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (img1[i][j] == 1) {
                    ones1[size1++] = new int[]{i, j};
                }
                if (img2[i][j] == 1) {
                    ones2[size2++] = new int[]{i, j};
                }
            }
        }
        int[][] counter = new int[60][60];

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                int dx = ones2[j][0] - ones1[i][0] + 30;
                int dy = ones2[j][1] - ones1[i][1] + 30;

                counter[dx][dy]++;
                res = Math.max(res, counter[dx][dy]);
            }
        }

        return res;
    }
}