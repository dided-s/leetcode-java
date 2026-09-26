package hard._1096_Brace_Expansion_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String expression, List<String> expected) {
        List<String> actual = new Solution().braceExpansionII(expression);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("{a,b}{c,{d,e}}", List.of("ac", "ad", "ae", "bc", "bd", "be")),
                Arguments.of("{{a,z},a{b,c},{ab,z}}", List.of("a", "ab", "ac", "z")),
                Arguments.of("{a,b}{c,d}", List.of("ac", "ad", "bc", "bd"))
        );
    }
}