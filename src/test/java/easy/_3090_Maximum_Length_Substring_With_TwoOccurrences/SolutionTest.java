package easy._3090_Maximum_Length_Substring_With_TwoOccurrences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int expected) {
        int actual = new Solution().maximumLengthSubstring(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("bcbbbcba", 4),
                Arguments.of("aaaa", 2),
                Arguments.of("dcfdddccb", 5)
        );
    }
}