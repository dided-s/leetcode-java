package medium._2333_Minimum_Sum_of_Squared_Difference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums1, int[] nums2, int k1, int k2, long expected) {
        long actual = new Solution().minSumSquareDiff(nums1, nums2, k1, k2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{2, 10, 20, 19},
                        0, 0, 579),
                Arguments.of(
                        new int[]{1, 4, 10, 12},
                        new int[]{5, 8, 6, 9},
                        1, 1, 43)
        );
    }
}