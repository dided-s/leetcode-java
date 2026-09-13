package medium._0835_Image_Overlap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[][] img1, int[][] img2, int expected) {
        int actual = new Solution().largestOverlap(img1, img2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}},
                        new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}},
                        3),
                Arguments.of(
                        new int[][]{{1}},
                        new int[][]{{1}},
                        1),
                Arguments.of(
                        new int[][]{{0}},
                        new int[][]{{0}},
                        0),
                Arguments.of(
                        new int[][]{{0}},
                        new int[][]{{1}},
                        0)
        );
    }
}