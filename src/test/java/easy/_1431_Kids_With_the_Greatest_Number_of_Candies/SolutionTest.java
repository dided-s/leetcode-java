package easy._1431_Kids_With_the_Greatest_Number_of_Candies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/easy/_1431_Kids_With_the_Greatest_Number_of_Candies/data.csv", delimiter = ' ')
    void testCsv(String input, int extraCandies, String output) {
        int[] candies = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Boolean> expected = Arrays.stream(output.split(","))
                .map(Boolean::parseBoolean)
                .toList();

        List<Boolean> actual = new Solution().kidsWithCandies(candies, extraCandies);

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}