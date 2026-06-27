package easy._1071_Greatest_Common_Divisor_of_Strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1071_Greatest_Common_Divisor_of_Strings/data.csv", delimiter = ',')
    void testCsv(String word1, String word2, String expected) {
        var actual = new Solution().gcdOfStrings(word1, word2);

        Assertions.assertEquals(expected, actual);
    }
}