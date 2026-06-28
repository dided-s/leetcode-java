package medium._238_Product_of_Array_Except_Self;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

import java.util.Arrays;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_238_Product_of_Array_Except_Self/data.csv", delimiter = ' ')
    void testCsv(String input, String expectedString) {
        int[] nums = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(expectedString);

        var actual = new Solution().productExceptSelf(nums);

        Assertions.assertArrayEquals(expected, actual,
                String.format("expected: %s\nactual: %s", Arrays.toString(expected), Arrays.toString(actual)));
    }
}