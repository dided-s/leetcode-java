package easy._724_Find_Pivot_Index;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_724_Find_Pivot_Index/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] nums = Utils.getIntArray(input);
        int actual = new Solution().pivotIndex(nums);

        Assertions.assertEquals(expected, actual);
    }
}