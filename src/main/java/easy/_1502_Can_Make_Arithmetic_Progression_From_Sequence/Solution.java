package easy._1502_Can_Make_Arithmetic_Progression_From_Sequence;

import annotations.Easy;

@Easy
public class Solution {

    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        if (min == max) return true;
        if ((max - min) % (n - 1) != 0) return false;

        int diff = (max - min) / (n - 1);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if ((arr[i] - min) % diff != 0) {
                return false;
            }

            int index = (arr[i] - min) / diff;
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
        }

        return true;
    }
}