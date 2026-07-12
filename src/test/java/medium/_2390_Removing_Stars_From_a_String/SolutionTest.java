package medium._2390_Removing_Stars_From_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_2390_Removing_Stars_From_a_String/data.csv", delimiter = ',')
    void testCsv(String s, String expected) {
        if (expected == null) {
            expected = "";
        }
        String actual = new Solution().removeStars(s);

        Assertions.assertEquals(expected, actual);
    }
}