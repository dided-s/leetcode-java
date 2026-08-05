package medium._3310_Remove_Methods_From_Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int k, int[][] invocations, int[] expected) {
        int[] actual = new Solution().remainingMethods(n, k, invocations)
                .stream().mapToInt(i -> i).toArray();

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(4, 1,
                        new int[][]{{1, 2}, {0, 1}, {3, 2}},
                        new int[]{0, 1, 2, 3}),
                Arguments.of(5, 0,
                        new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}},
                        new int[]{3, 4}),
                Arguments.of(3, 2,
                        new int[][]{{1, 2}, {0, 1}, {2, 0}},
                        new int[]{}),
                Arguments.of(2, 0,
                        new int[][]{},
                        new int[] {1})
        );
    }
}