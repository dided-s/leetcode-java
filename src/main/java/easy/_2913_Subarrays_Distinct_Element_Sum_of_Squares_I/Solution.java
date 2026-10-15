package easy._2913_Subarrays_Distinct_Element_Sum_of_Squares_I;

import annotations.Easy;

import java.util.List;

@Easy
public class Solution {

    public int sumCounts(List<Integer> nums) {

        int answer = 0;

        for (int size = 1; size <= nums.size(); size++) {
            int[] freq = new int[101];
            int uniqueNumber = 0;

            for (int i = 0; i < size; i++) {
                freq[nums.get(i)]++;
                if (freq[nums.get(i)] == 1) {
                    uniqueNumber++;
                }
            }

            answer = answer + uniqueNumber * uniqueNumber;

            for (int i = 0; i + size < nums.size(); i++) {
                freq[nums.get(i)]--;

                if (freq[nums.get(i)] == 0) {
                    uniqueNumber--;
                }

                freq[nums.get(i + size)]++;
                if (freq[nums.get(i + size)] == 1) {
                    uniqueNumber++;
                }

                answer = answer + uniqueNumber * uniqueNumber;
            }
        }

        return answer;
    }
}