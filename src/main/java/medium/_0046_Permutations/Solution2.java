package medium._0046_Permutations;

import annotations.Medium;
import annotations.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Medium
@Topic("Combinatorics")
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(getList(nums));

        while (nextPermutation(nums)) {
            result.add(getList(nums));
        }

        return result;
    }

    public List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int x : nums) {
            list.add(x);
        }

        return list;
    }

    public boolean nextPermutation(int[] nums) {
        int length = nums.length;

        // 1. find left index where nums[left] < nums[left + 1]
        int left = length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {
            left--;
        }

        // 2. there is no next permutation. It is reverse order array. We need only reverse it back
        if (left < 0) {
            reverse(nums, 0, length - 1);
            return false;
        }

        // 3. find right index, where nums[left] < nums[right]12]
        int right = length - 1;
        while (right >= 0 && nums[left] >= nums[right]) {
            right--;
        }

        // 4. swap left and right
        swap(nums, left, right);

        // 5. reverse tail. Because now tail is reverse order. We need to make it ascending
        reverse(nums, left + 1, length - 1);
        return true;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);

            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}