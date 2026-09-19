package medium._1401_Circle_and_Rectangle_Overlapping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2, boolean expected) {
        boolean actual = new Solution().checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(1, 0, 0, 1, -1, 3, 1, true),
                Arguments.of(1, 1, 1, 1, -3, 2, -1, false),
                Arguments.of(1, 0, 0, -1, 0, 0, 1, true),
                Arguments.of(2, 8, 6, 5, 1, 10, 4, true),
                Arguments.of(1, 5, -2, 0, 0, 10, 2, false)
        );
    }
}