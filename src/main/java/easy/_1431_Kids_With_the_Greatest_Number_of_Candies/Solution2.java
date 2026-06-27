package easy._1431_Kids_With_the_Greatest_Number_of_Candies;

import annotations.Easy;
import annotations.LeetCode75;

import java.util.Arrays;
import java.util.List;

@Easy
@LeetCode75("Array / String")
public class Solution2 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = max(candies);
        return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= max)
                .toList();
    }

    private static int max(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException();
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }

        return max;
    }
}