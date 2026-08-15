package medium._3702_Longest_Subsequence_With_Non_Zero_Bitwise_XOR;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int expected) {
        int actual = new Solution().longestSubsequence(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{2, 3, 4}, 3)
        );
    }
}