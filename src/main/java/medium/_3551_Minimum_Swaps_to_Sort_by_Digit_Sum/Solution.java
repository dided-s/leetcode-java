package medium._3551_Minimum_Swaps_to_Sort_by_Digit_Sum;

import annotations.Medium;

import java.util.Arrays;

@Medium
class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[] digitSums = new int[n];
        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            digitSums[i] = sumOfDigits(nums[i]);
            indexes[i] = i;
        }

        int[] newIndexes = Arrays.stream(indexes)
                .boxed()
                .sorted((i, j) -> {
                    int diff = digitSums[i] - digitSums[j];
                    if (diff == 0) {
                        return nums[i] - nums[j];
                    }
                    return diff;
                })
                .mapToInt(Integer::intValue)
                .toArray();

        int[] groups = new int[n];
        int groupNum = 1;

        for (int i = 0; i < n; i++) {
            if (groups[i] == 0) {
                int nextIndex = newIndexes[i];
                groups[i] = groupNum;

                while (i != nextIndex) {
                    groups[nextIndex] = groupNum;
                    nextIndex = newIndexes[nextIndex];
                }

                groupNum++;
            }
        }

        return n - (groupNum - 1);
    }

    public static int sumOfDigits(int number) {
        long n = Math.abs((long) number);
        int sum = 0;

        while (n > 0) {
            sum += (int) (n % 10);
            n /= 10;
        }

        return sum;
    }
}