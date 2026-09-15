package hard._2472_Maximum_Number_of_Non_overlapping_Palindrome_Substrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, int k, int expected) {
        int actual = new Solution().maxPalindromes(s, k);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("abaccdbbd", 3, 2),
                Arguments.of("adbcda", 2, 0),
                Arguments.of("fttfjofpnpfydwdwdnns", 2, 4),
                Arguments.of("gataghmwwmoeyeov", 4, 3)
        );
    }
}