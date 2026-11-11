package medium._3693_Climbing_Stairs_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int n, int[] costs, int expected) {
        int actual = new Solution().climbStairs(n, costs);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2, 3, 4}, 13),
                Arguments.of(4, new int[]{5, 1, 6, 2}, 11),
                Arguments.of(3, new int[]{9, 8, 3}, 12),
                Arguments.of(1, new int[]{9}, 10)
        );
    }
}