package medium._0453_Minimum_Moves_to_Equal_Array_Elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().minMoves(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 1, 1}, 0)
        );
    }
}