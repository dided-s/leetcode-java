package medium._0046_Permutations;

import annotations.Medium;
import annotations.Topic;

import java.util.ArrayList;
import java.util.List;

@Medium
@Topic("Combinatorics")
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        permute(0, nums, answer);
        return answer;
    }

    private void permute(int pos, int[] nums, List<List<Integer>> answer) {
        int n = nums.length;
        if (pos == n) {
            answer.add(toList(nums));
            return;
        }

        for (int i = pos; i < n; i++) {
            swap(nums, pos, i);

            permute(pos + 1, nums, answer);

            swap(nums, pos, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> temp = new ArrayList<>(nums.length);
        for (int it : nums) {
            temp.add(it);
        }

        return temp;
    }
}