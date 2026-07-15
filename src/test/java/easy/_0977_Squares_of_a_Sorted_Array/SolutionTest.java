package easy._0977_Squares_of_a_Sorted_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0977_Squares_of_a_Sorted_Array/data.csv", delimiter = ' ')
    void testCsv(String input, String output) {
        int[] nums = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        int[] actual = new Solution().sortedSquares(nums);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }
}