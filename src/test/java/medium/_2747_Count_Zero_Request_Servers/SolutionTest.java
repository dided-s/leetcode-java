package medium._2747_Count_Zero_Request_Servers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int[][] logs, int x, int[] queries, int[] expected) {
        int[] actual = new Solution().countServers(n, logs, x, queries);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(3, new int[][]{
                                {1, 3},
                                {2, 6},
                                {1, 5}},
                        5, new int[]{10, 11},
                        new int[]{1, 2}),
                Arguments.of(3, new int[][]{
                                {2, 4},
                                {2, 1},
                                {1, 2},
                                {3, 1}},
                        2, new int[]{3, 4},
                        new int[]{0, 1})
        );
    }
}