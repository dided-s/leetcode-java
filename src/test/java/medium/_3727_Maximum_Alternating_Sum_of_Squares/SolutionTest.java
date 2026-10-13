package medium._3727_Maximum_Alternating_Sum_of_Squares;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, long expected) {
        long actual = new Solution().maxAlternatingSum(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 12),
                Arguments.of(new int[]{1, -1, 2, -2, 3, -3}, 16),
                Arguments.of(new int[]{-6, -15, -4, 6, -6}, 245)
        );
    }
}