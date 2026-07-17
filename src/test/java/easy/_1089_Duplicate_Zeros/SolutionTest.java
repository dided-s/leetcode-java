package easy._1089_Duplicate_Zeros;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1089_Duplicate_Zeros/data.csv", delimiter = ' ')
    void testCsv(String input, String output) {
        int[] arr = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        new Solution().duplicateZeros(arr);
        Assertions.assertArrayEquals(expected, arr, Utils.assertionArraysMessage(expected, arr));
    }
}