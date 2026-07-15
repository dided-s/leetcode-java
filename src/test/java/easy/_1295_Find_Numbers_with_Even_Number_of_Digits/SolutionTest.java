package easy._1295_Find_Numbers_with_Even_Number_of_Digits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1295_Find_Numbers_with_Even_Number_of_Digits/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().findNumbers(nums);
        Assertions.assertEquals(expected, actual);
    }
}