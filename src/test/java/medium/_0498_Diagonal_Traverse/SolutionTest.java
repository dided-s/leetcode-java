package medium._0498_Diagonal_Traverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[][] mat, int[] expected) {
        int[] actual = new Solution().findDiagonalOrder(mat);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}),
                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}},
                        new int[]{1, 2, 3, 4}),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5}, {6}},
                        new int[]{1, 2, 4, 6, 5, 3}),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4}, {5, 6, 7, 8}, {9}},
                        new int[]{1, 2, 4, 5, 3, 6, 9, 7, 8}
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4}, {5, 6, 7, 8}, {9}, {10}, {11}, {12}},
                        new int[]{1, 2, 4, 5, 3, 6, 9, 10, 7, 8, 11, 12}
                ),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4}, {5, 6, 7, 8}, {9}, {10}, {11}, {12}, {13}, {14}, {15}},
                        new int[]{1, 2, 4, 5, 3, 6, 9, 10, 7, 8, 11, 12, 13, 14, 15}
                ));
    }
}