package medium._0912_Sort_an_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int[] expected) {
        int[] actual = new Solution().sortArray(nums);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{5, 2, 3, 1}, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{5, 1, 1, 2, 0, 0}, new int[]{0, 0, 1, 1, 2, 5})
        );
    }
}