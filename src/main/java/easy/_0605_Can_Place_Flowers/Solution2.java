package easy._0605_Can_Place_Flowers;

import annotations.Easy;
import annotations.LeetCode75;

@Easy
@LeetCode75("Array / String")
public class Solution2 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;
        if (flowerbed.length == 1 && flowerbed[0] == 0) return true;
        if (n == 0) return true;

        int index = 0;

        while (index < flowerbed.length) {
            int previous = (index == 0 || flowerbed[index - 1] == 0) ? 0 : 1;
            int next = (index == flowerbed.length - 1 || flowerbed[index + 1] == 0) ? 0 : 1;
            if (previous == 0 && flowerbed[index] == 0 && next == 0) {
                if (n == 1) return true;
                n--;
                flowerbed[index] = 1;
                index += 2;
            } else index++;
        }
        return false;
    }
}