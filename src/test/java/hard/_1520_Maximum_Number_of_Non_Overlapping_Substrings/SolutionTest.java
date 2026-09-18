package hard._1520_Maximum_Number_of_Non_Overlapping_Substrings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, Set<String> expected) {
        List<String> actual = new Solution().maxNumOfSubstrings(s);

        Assertions.assertEquals(expected, Set.copyOf(actual));
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("adefaddaccc", Set.of("e", "f", "ccc")),
                Arguments.of("abbaccd", Set.of("d", "bb", "cc")),
                Arguments.of("abab", Set.of("abab")),
                Arguments.of("dzdabazbbccd", Set.of("cc"))
        );
    }
}