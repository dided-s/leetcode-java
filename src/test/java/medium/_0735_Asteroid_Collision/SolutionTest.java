package medium._0735_Asteroid_Collision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Utils;

public class SolutionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/medium/_0735_Asteroid_Collision/data.csv", delimiter = ';')
    void testCsv(String input, String output) {
        if (input == null) {
            input = "";
        }

        if (output == null) {
            output = "";
        }

        int[] asteroids = Utils.getIntArray(input);
        int[] expected = Utils.getIntArray(output);

        int[] actual = new Solution().asteroidCollision(asteroids);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }
}