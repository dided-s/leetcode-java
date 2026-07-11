package easy._1207_Unique_Number_of_Occurrences;

import annotations.Easy;
import annotations.LeetCode75;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Easy
@LeetCode75("Hash Map / Set")
public class Solution {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberOfOccurrences = new HashMap<>();
        for (int num : arr) {
            if (!numberOfOccurrences.containsKey(num)) {
                numberOfOccurrences.put(num, 0);
            }
            numberOfOccurrences.put(num, numberOfOccurrences.get(num) + 1);
        }
        int uniqueValuesSize = numberOfOccurrences.size();
        int uniqueNumberOfOccurrencesSize = Set.copyOf(numberOfOccurrences.values()).size();

        return uniqueNumberOfOccurrencesSize == uniqueValuesSize;
    }

}