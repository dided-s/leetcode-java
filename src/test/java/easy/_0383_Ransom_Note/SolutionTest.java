package easy._0383_Ransom_Note;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0383_Ransom_Note/data.csv", delimiter = ';')
    void testCsv(String ransomNote, String magazine, boolean expected) {
        boolean actual = new Solution().canConstruct(ransomNote, magazine);

        Assertions.assertEquals(expected, actual);
    }
}