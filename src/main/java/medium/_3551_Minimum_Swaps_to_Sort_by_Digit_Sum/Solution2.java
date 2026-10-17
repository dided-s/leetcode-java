package medium._3551_Minimum_Swaps_to_Sort_by_Digit_Sum;

import annotations.Medium;

import java.util.Arrays;
import java.util.Comparator;

@Medium
class Solution2 {

    public int minSwaps(int[] nums) {
        Comparator<Integer> comparator = (i, j) -> {
            int sum1 = sumOfDigits(nums[i]);
            int sum2 = sumOfDigits(nums[j]);

            if (sum1 == sum2) {
                return nums[i] - nums[j];
            } else {
                return sum1 - sum2;
            }
        };

        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        int[] newIndexes = Arrays.stream(indexes)
                .boxed()
                .sorted(comparator)
                .mapToInt(Integer::intValue)
                .toArray();

        int[] groups = new int[nums.length];
        int groupNum = 1;

        for (int i = 0; i < nums.length; i++) {
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

        return nums.length - (groupNum - 1);
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