package easy._1502_Can_Make_Arithmetic_Progression_From_Sequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(int[] arr, boolean expected) {
        boolean actual = new Solution().canMakeArithmeticProgression(arr);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 5, 1}, true),
                Arguments.of(new int[]{1, 2, 4}, false)
        );
    }
}