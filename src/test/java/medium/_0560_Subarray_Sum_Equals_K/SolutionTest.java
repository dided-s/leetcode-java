package medium._0560_Subarray_Sum_Equals_K;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] arr, int target, int expected) {
        int actual = new Solution().minSumOfLengths(arr, target);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 4, 3}, 3, 2),
                Arguments.of(new int[]{7, 3, 4, 7}, 7, 2),
                Arguments.of(new int[]{4, 3, 2, 6, 2, 3, 4}, 6, -1)
        );
    }
}