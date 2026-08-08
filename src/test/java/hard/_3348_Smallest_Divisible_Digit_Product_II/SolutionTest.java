package hard._3348_Smallest_Divisible_Digit_Product_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String num, long t, String expected) {
        String actual = new Solution().smallestNumber(num, t);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("1234", 256, "1488"),
                Arguments.of("12355", 50, "12355"),
                Arguments.of("11111", 26, "-1")
        );
    }
}