package easy._0605_Can_Place_Flowers;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed == null || flowerbed.length == 0) return false;
        if (flowerbed.length == 1) return flowerbed[0] == 0;

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            if (n-- == 1) return true;
            flowerbed[0] = 1;
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            if (n-- == 1) return true;
            flowerbed[flowerbed.length - 1] = 1;
        }

        int index = 1;

        while (index < flowerbed.length - 1) {
            if (flowerbed[index - 1] == 0 && flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
                if (n-- == 1) return true;
                flowerbed[index] = 1;
                index++;
            }
            index++;
        }

        return false;
    }
}