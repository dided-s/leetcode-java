package medium._1424_Diagonal_Traverse_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(List<List<Integer>> mat, int[] expected) {
        int[] actual = new Solution().findDiagonalOrder(mat);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(1, 2, 3, 4, 5),
                                List.of(6, 7),
                                List.of(8),
                                List.of(9, 10, 11),
                                List.of(12, 13, 14, 15, 16)),
                        new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16}
                ));
    }
}