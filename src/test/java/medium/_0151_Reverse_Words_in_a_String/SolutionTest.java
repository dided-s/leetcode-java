package medium._0151_Reverse_Words_in_a_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0151_Reverse_Words_in_a_String/data.csv", delimiter = ',')
    void testCsv(String str, String expected) {
        var actual = new Solution().reverseWords(str);

        Assertions.assertEquals(expected, actual);
    }
}