package medium._2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int k, int expected) {
        int actual = new Solution().maxSubarrayLength(nums, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2, 6),
                Arguments.of(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1, 2),
                Arguments.of(new int[]{5, 5, 5, 5, 5, 5, 5}, 4, 4)
        );
    }
}