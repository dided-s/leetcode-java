package medium._1477_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int k, int expected) {
        int actual = new Solution().subarraySum(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 1, 1}, 2, 2),
                Arguments.of(new int[]{1, 2, 3}, 3, 2),
                Arguments.of(new int[]{1}, 0, 0),
                Arguments.of(new int[]{-1, -1, 1}, 0, 1),
                Arguments.of(new int[]{-1, -1, 1}, 1, 1)
        );
    }
}