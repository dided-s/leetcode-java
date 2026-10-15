package easy._2913_Subarrays_Distinct_Element_Sum_of_Squares_I;

import annotations.Easy;

import java.util.List;

@Easy
public class Solution3 {

    public int sumCounts(List<Integer> nums) {
        int result = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean[] visited = new boolean[101];
            for (int j = i; j < n; j++) {
                int num = nums.get(j);
                if (!visited[num]) {
                    visited[num] = true;
                    count++;
                }
                result += count * count;
            }

        }

        return result;
    }
}