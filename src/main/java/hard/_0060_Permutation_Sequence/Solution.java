package hard._0060_Permutation_Sequence;

import annotations.Hard;
import annotations.Topic;

@Hard
@Topic("Combinatorics")
public class Solution {

    public String getPermutation(int n, int k) {
        // 1. create ascending array
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        // 2. find max factorial (and factorial num) that is less than k
        int factorial = 1;
        int factorialNum = 0;

        while (factorial * (factorialNum + 1) < k) {
            factorialNum++;
            factorial *= factorialNum;
        }

        while (k > 1) {
            // 3. We need to use tail by our array with length factorial
            // Then we need to swap left = nums.length - 1 - factorialNum and others, while k > factorial.
            // When k <= factorial we need to decrease our factorial by one
            int left = nums.length - 1 - factorialNum;
            int right = left + 1;

            while (k > factorial) {
                k -= factorial;
                swap(nums, left, right);
                right++;
            }

            factorial /= factorialNum;
            factorialNum--;
        }

        // 4. Create answer string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }

        return sb.toString();
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}