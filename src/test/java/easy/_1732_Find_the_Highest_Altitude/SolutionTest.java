package easy._1732_Find_the_Highest_Altitude;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1732_Find_the_Highest_Altitude/data.csv", delimiter = ' ')
    void testCsv(String input, int expected) {
        int[] gain = Utils.getIntArray(input);
        int actual = new Solution().largestAltitude(gain);

        Assertions.assertEquals(expected, actual);
    }
}