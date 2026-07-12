package medium._2352_Equal_Row_and_Column_Pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[][] grid, int expected) {
        int actual = new Solution().equalPairs(grid);
        Assertions.assertEquals(expected, actual);

    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {3, 2, 1},
                        {1, 7, 6},
                        {2, 7, 7}}, 1),
                Arguments.of(new int[][]{
                        {3, 1, 2, 2},
                        {1, 4, 4, 5},
                        {2, 4, 2, 2},
                        {2, 4, 2, 2}}, 3),
                Arguments.of(new int[][]{
                        {11, 1},
                        {1, 11}}, 2)
        );
    }
}