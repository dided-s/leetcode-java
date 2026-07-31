package medium._0567_Permutation_in_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s1, String s2, boolean expected) {
        boolean actual = new Solution().checkInclusion(s1, s2);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("adc", "dcda", true),
                Arguments.of("a", "ab", true),
                Arguments.of("abc", "bbbca", true)
        );
    }
}