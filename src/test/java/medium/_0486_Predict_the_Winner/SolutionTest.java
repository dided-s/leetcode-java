package medium._0486_Predict_the_Winner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] nums, boolean expected) {
        boolean actual = new Solution().predictTheWinner(nums);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of(new int[]{1, 5, 2}, false),
                Arguments.of(new int[]{1, 5, 233, 7}, true),
                Arguments.of(new int[]{2, 4, 55, 6, 8}, false)
        );
    }
}