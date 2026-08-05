package easy._0119_Pascals_Triangle_II;

import annotations.Easy;
import annotations.Explore;

import java.util.ArrayList;
import java.util.List;

@Easy
@Explore("Recursion")
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        int[][] cache = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {
            row.add(getCell(rowIndex, i, cache));
        }

        return row;
    }

    public int getCell(int rowIndex, int cellIndex, int[][] cache) {
        // check cache
        if (cache[rowIndex][cellIndex] != 0) return cache[rowIndex][cellIndex];
        if (rowIndex == 0) return 1;
        if (cellIndex == 0 || cellIndex == rowIndex) return 1;

        // save in cache
        cache[rowIndex][cellIndex] = getCell(rowIndex - 1, cellIndex - 1, cache)
                + getCell(rowIndex - 1, cellIndex, cache);

        return cache[rowIndex][cellIndex];
    }
}