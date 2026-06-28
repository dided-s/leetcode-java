package medium._11_Container_With_Most_Water;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_11_Container_With_Most_Water/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] heights = Utils.getIntArray(input);

        int actual = new Solution().maxArea(heights);
        Assertions.assertEquals(expected, actual);
    }
}