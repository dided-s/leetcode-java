package medium._0394_Decode_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0394_Decode_String/data.csv", delimiter = ';')
    void testCsv(String s, String expected) {
        String actual = new Solution().decodeString(s);

        Assertions.assertEquals(expected, actual);
    }
}