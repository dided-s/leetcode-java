package easy._3484_Unique_3_Digit_Even_Numbers;

import annotations.Easy;

@Easy
public class Solution {

    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int answer = 0;

        for (int a = 1; a <= 9; a++) {
            if (freq[a] == 0) continue;
            freq[a]--;
            for (int b = 0; b <= 9; b++) {
                if (freq[b] == 0) continue;
                freq[b]--;
                for (int c = 0; c <= 8; c += 2) {
                    if (freq[c] == 0) continue;
                    answer++;
                }
                freq[b]++;
            }
            freq[a]++;
        }

        return answer;
    }
}