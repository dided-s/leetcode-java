package easy._0414_Third_Maximum_Number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0414_Third_Maximum_Number/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] nums = Utils.getIntArray(input);

        int actual = new Solution().thirdMax(nums);

        Assertions.assertEquals(expected, actual);
    }
}