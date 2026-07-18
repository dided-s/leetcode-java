package easy._0067_Add_Binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0067_Add_Binary/data.csv", delimiter = ' ')
    void testCsv(String a, String b, String expected) {
        String actual = new Solution().addBinary(a, b);

        Assertions.assertEquals(expected, actual);
    }
}