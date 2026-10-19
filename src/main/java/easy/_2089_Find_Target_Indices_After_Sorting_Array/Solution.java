package easy._2089_Find_Target_Indices_After_Sorting_Array;

import annotations.Easy;

import java.util.ArrayList;
import java.util.List;

@Easy
public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        int targetCount = 0;
        int lessCount = 0;

        for (int num : nums) {
            if (num == target) {
                targetCount++;
            } else if (num < target) {
                lessCount++;
            }
        }

        List<Integer> result = new ArrayList<>(targetCount);
        for (int i = lessCount; i < lessCount + targetCount; i++) {
            result.add(i);
        }

        return result;
    }
}