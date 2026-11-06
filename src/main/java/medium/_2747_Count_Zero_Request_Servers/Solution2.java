package medium._2747_Count_Zero_Request_Servers;

import annotations.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Medium
class Solution2 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        //System.out.println(Arrays.deepToString(logs));
        //System.out.println(binarySearchTwoDimensionalArray(logs, 1, 1));

        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < queries.length; i++) {
            int end = queries[i];
            int start = end - x;
            int left = binarySearchTwoDimensionalArray(logs, start, 1);
            int right = binarySearchTwoDimensionalArray(logs, end + 1, 1) - 1;

            //System.out.println(start + " " + end);
            //System.out.println(left + " " + right);

            unique.clear();

            for (int j = left; j <= right; j++) {
                //System.out.println(j + " - " + logs[j][0]);
                unique.add(logs[j][0]);
            }

            answer[i] = n - unique.size();
        }

        return answer;
    }

    private int binarySearchTwoDimensionalArray(int[][] array, int target, int index) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid][index] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}