package medium._0462_Minimum_Moves_to_Equal_Array_Elements_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().minMoves2(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{1, 10, 2, 9}, 16)
        );
    }
}