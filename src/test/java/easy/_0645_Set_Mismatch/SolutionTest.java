package easy._0645_Set_Mismatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, int[] expected) {
        int[] actual = new Solution().findErrorNums(nums);

        Assertions.assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 4}, new int[]{2, 3}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 2})
        );
    }
}