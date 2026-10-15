package easy._2913_Subarrays_Distinct_Element_Sum_of_Squares_I;

import annotations.Easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Easy
public class Solution2 {

    public int sumCounts(List<Integer> nums) {

        int answer = 0;

        for (int size = 1; size <= nums.size(); size++) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < size; i++) {
                freq.put(nums.get(i), freq.getOrDefault(nums.get(i), 0) + 1);
            }
            //System.out.println(size + " " + freq + " " + freq.size());
            answer = answer + freq.size() * freq.size();

            for (int i = 0; i + size < nums.size(); i++) {
                freq.put(nums.get(i), freq.get(nums.get(i)) - 1);

                if (freq.get(nums.get(i)) == 0) {
                    freq.remove(nums.get(i));
                }

                int newValue = nums.get(i + size);
                freq.put(newValue, freq.getOrDefault(newValue, 0) + 1);

                //System.out.println(size + " " + freq + " " + freq.size());
                answer = answer + freq.size() * freq.size();
            }
        }

        return answer;
    }
}