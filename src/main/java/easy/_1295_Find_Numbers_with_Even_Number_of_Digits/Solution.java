package easy._1295_Find_Numbers_with_Even_Number_of_Digits;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Arrays 101")
public class Solution {

    /**
     * log10(7) ≈ 0.84
     * log10(10) = 1
     * log10(100) = 2
     * log10(123) ≈ 2.089
     */
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if ((int) Math.log10(num) % 2 != 0) {
                result++;
            }
        }
        return result;
    }
}