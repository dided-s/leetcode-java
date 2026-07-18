package easy._1051_Height_Checker;

import annotations.Easy;
import annotations.Explore;

@Easy
@Explore("Arrays 101")
public class Solution {

    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] freq = new int[101];

        for (int height : heights) {
            freq[height] += 1;
        }
        int currentHeight = 1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            while (freq[currentHeight] == 0) {
                currentHeight += 1;
            }
            if (heights[i] != currentHeight) {
                answer += 1;
            }
            freq[currentHeight] -= 1;
        }
        return answer;
    }
}