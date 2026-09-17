package medium._1477_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import annotations.Medium;

import java.util.HashMap;

@Medium
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}