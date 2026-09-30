package medium._1111_Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Utils;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String seq, int[] expected) {
        int[] actual = new Solution().maxDepthAfterSplit(seq);

        Assertions.assertArrayEquals(expected, actual, Utils.assertionArraysMessage(expected, actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("(()())", new int[]{0, 1, 1, 1, 1, 0}),
                Arguments.of("()(())()", new int[]{0, 0, 0, 1, 1, 0, 1, 1})
        );
    }
}