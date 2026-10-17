package medium._3551_Minimum_Swaps_to_Sort_by_Digit_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().minSwaps(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{37, 100}, 1),
                Arguments.of(new int[]{22, 14, 33, 7}, 0),
                Arguments.of(new int[]{18, 43, 34, 16}, 2)
        );
    }
}