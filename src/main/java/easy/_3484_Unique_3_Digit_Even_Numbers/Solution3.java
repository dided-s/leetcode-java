package easy._3484_Unique_3_Digit_Even_Numbers;

import annotations.Easy;

@Easy
public class Solution3 {

    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int digit : digits) {
            freq[digit]++;
        }

        int answer = 0;

        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 8; c += 2) {
                    int[] need = new int[10];

                    need[a]++;
                    need[b]++;
                    need[c]++;

                    boolean possible = true;

                    for (int d = 0; d <= 9; d++) {
                        if (need[d] > freq[d]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}