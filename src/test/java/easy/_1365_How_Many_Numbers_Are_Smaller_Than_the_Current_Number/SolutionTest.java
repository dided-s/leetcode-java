package easy._1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

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
        int[] actual = new Solution().smallerNumbersThanCurrent(nums);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{8, 1, 2, 2, 3}, new int[]{4, 0, 1, 1, 3}),
                Arguments.of(new int[]{6, 5, 4, 8}, new int[]{2, 1, 0, 3}),
                Arguments.of(new int[]{7, 7, 7, 7}, new int[]{0, 0, 0, 0})
        );
    }
}