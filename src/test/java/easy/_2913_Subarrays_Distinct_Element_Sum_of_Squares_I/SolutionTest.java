package easy._2913_Subarrays_Distinct_Element_Sum_of_Squares_I;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(List<Integer> nums, int expected) {
        int actual = new Solution().sumCounts(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 1), 15),
                Arguments.of(List.of(1, 1), 3),
                Arguments.of(List.of(2, 2, 5, 5), 22)
        );
    }
}