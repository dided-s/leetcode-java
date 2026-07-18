package easy._1051_Height_Checker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1051_Height_Checker/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] heights = Utils.getIntArray(input);

        int actual = new Solution().heightChecker(heights);

        Assertions.assertEquals(expected, actual);
    }
}