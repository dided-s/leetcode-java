package medium._0835_Image_Overlap;

import annotations.Medium;

@Medium
public class Solution2 {

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int maxOverlap = 0;
        for (int dx = 0; dx < n; dx++) {
            for (int dy = 0; dy < n; dy++) {
                int dPlusPlus = 0;
                int dPlusMinus = 0;
                int dMinusPlus = 0;
                int dMinusMinus = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (img2[i][j] == 0) continue;

                        if (i + dx < n && j + dy < n && img1[i + dx][j + dy] == 1) dPlusPlus++;
                        if (i + dx < n && j - dy >= 0 && img1[i + dx][j - dy] == 1) dPlusMinus++;
                        if (i - dx >= 0 && j + dy < n && img1[i - dx][j + dy] == 1) dMinusPlus++;
                        if (i - dx >= 0 && j - dy >= 0 && img1[i - dx][j - dy] == 1) dMinusMinus++;
                    }
                }

                maxOverlap = Math.max(maxOverlap, dPlusPlus);
                maxOverlap = Math.max(maxOverlap, dPlusMinus);
                maxOverlap = Math.max(maxOverlap, dMinusPlus);
                maxOverlap = Math.max(maxOverlap, dMinusMinus);
            }
        }

        return maxOverlap;
    }
}