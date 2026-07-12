package easy._0605_Can_Place_Flowers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_0605_Can_Place_Flowers/data.csv", delimiter = ' ')
    void testCsv(String flowerbedString, int n, boolean expected) {
        int[] flowerbed = Utils.getIntArray(flowerbedString);

        var actual = new Solution().canPlaceFlowers(flowerbed, n);
        Assertions.assertEquals(expected, actual);
    }
}