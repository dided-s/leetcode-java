package medium._0167_Two_Sum_II_Input_array_is_sorted;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0167_Two_Sum_II_Input_array_is_sorted/data.csv", delimiter = ' ')
    void testCsv(String input, int target, String output) {
        int[] numbers = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        int[] actual = new Solution().twoSum(numbers, target);

        Assertions.assertArrayEquals(expected, actual);
    }
}