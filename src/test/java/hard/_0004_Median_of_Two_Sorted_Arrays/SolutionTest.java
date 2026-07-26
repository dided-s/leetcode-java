package hard._0004_Median_of_Two_Sorted_Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums1, int[] nums2, double expected) {
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);

        Assertions.assertEquals(expected, actual, 0.00001);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(
                        new int[]{1, 3},
                        new int[]{2},
                        2.00000),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{3, 4},
                        2.50000),
                Arguments.of(
                        new int[]{1, 3, 6, 8, 12, 14, 19, 22},
                        new int[]{1, 7, 15, 21, 22, 23, 24, 25, 26, 27, 28},
                        19.00000
                )
        );
    }
}