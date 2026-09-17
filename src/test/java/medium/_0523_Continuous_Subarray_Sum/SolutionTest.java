package medium._0523_Continuous_Subarray_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int k, boolean expected) {
        boolean actual = new Solution().checkSubarraySum(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{23, 2, 4, 6, 7}, 6, true),
                Arguments.of(new int[]{23, 2, 6, 4, 7}, 6, true),
                Arguments.of(new int[]{23, 2, 6, 4, 7}, 13, false)
        );
    }
}