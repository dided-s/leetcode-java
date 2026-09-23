package medium._1658_Minimum_Operations_to_Reduce_X_to_Zero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int x, int expected) {
        int actual = new Solution().minOperations(nums, x);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 1, 4, 2, 3}, 5, 2),
                Arguments.of(new int[]{5, 6, 7, 8, 9}, 4, -1),
                Arguments.of(new int[]{3, 2, 20, 1, 1, 3}, 10, 5),
                Arguments.of(new int[]{1, 1, 3, 2, 5}, 5, 1),
                Arguments.of(new int[]{1, 1}, 3, -1)
        );
    }
}