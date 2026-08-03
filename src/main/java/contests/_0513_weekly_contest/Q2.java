package contests._0513_weekly_contest;

import annotations.Medium;

@Medium
public class Q2 {

    // Q2. Count Subarrays With Even Odd Ratio I
    public int countRatioSubarrays(int[] nums, int a, int b) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] % 2 == 1 ? 1 : 0;

        int[] prefixOddCount = new int[nums.length];
        int answer = 0;

        prefixOddCount[0] = (nums[0] % 2 == 1) ? 1 : 0;

        for (int i = 1; i < nums.length; i++) {
            prefixOddCount[i] = prefixOddCount[i - 1];
            if (nums[i] % 2 == 1) {
                prefixOddCount[i]++;
            }
        }

        int subArrayLength;
        int oddCount;
        int evenCount;

        for (int i = 0; i < nums.length; i++) {
            oddCount = prefixOddCount[i];
            evenCount = i + 1 - oddCount;

            if (isCondition(evenCount, oddCount, a, b)) {
                //System.out.println("left = " + 0 + " right = " + i);
                answer++;
            }
        }

        for (int left = 0; left < nums.length - 1; left++) {
            // left not included and right included
            for (int right = left + 1; right < nums.length; right++) {
                subArrayLength = right - left;
                oddCount = prefixOddCount[right] - prefixOddCount[left];
                evenCount = subArrayLength - oddCount;

                if (isCondition(evenCount, oddCount, a, b)) {
                    //System.out.println("left = " + (left + 1) + " right = " + right);
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean isCondition(int evenCount, int oddCount, int a, int b) {
        if (oddCount == 0) return false;

        return evenCount * b <= oddCount * a;
    }
}
