package easy._3484_Unique_3_Digit_Even_Numbers;

import annotations.Easy;

import java.util.HashSet;
import java.util.Set;

@Easy
public class Solution2 {

    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (digits[k] % 2 == 1 || k == j || k == i) continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    nums.add(num);
                }
            }
        }
        return nums.size();
    }
}