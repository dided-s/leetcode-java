package easy._0009_Palindrome_Number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0009_Palindrome_Number/data.csv", delimiter = ' ')
    void testCsv(int x, boolean expected) {
        boolean actual = new Solution().isPalindrome(x);

        Assertions.assertEquals(expected, actual);
    }
}