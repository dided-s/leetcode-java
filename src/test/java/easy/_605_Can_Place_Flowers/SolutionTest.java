package easy._605_Can_Place_Flowers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_605_Can_Place_Flowers/data.csv", delimiter = ' ')
    void testCsv(String flowerbedString, int n, boolean expected) {
        int[] flowerbed = Arrays.stream(flowerbedString.split(","))
                .mapToInt(Integer::parseInt).toArray();

        var actual = new Solution().canPlaceFlowers(flowerbed, n);
        Assertions.assertEquals(expected, actual);
    }
}