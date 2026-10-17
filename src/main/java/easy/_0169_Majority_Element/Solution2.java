package easy._0169_Majority_Element;

import annotations.Easy;

import java.util.HashMap;
import java.util.Map;

@Easy
public class Solution2 {

    static class Counter {
        int count;

        public Counter() {
            this.count = 0;
        }
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Counter> freq = new HashMap<>();
        int maxCount = 0;
        int max = 0;

        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, new Counter());
            }
            freq.get(num).count++;

            if (freq.get(num).count > maxCount) {
                maxCount = freq.get(num).count;
                max = num;
            }
        }

        return max;
    }
}