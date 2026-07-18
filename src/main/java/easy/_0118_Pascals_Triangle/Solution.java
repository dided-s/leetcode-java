package easy._0118_Pascals_Triangle;

import annotations.Easy;
import annotations.Explore;

import java.util.ArrayList;
import java.util.List;

@Easy
@Explore("Array and String")
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < result.get(i - 1).size(); ++j) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(1);

            result.add(row);
        }

        return result;
    }
}