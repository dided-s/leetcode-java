package medium._3499_Maximize_Active_Section_with_Trade_I;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_3499_Maximize_Active_Section_with_Trade_I/data.csv", delimiter = ' ')
    void testCsv(String s, int expected) {
        int actual = new Solution().maxActiveSectionsAfterTrade(s);
        Assertions.assertEquals(expected, actual);
    }
}