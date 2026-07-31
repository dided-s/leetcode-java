package medium._0784_Letter_Case_Permutation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, Set<String> expected) {
        Set<String> actual = Set.copyOf(new Solution().letterCasePermutation(s));

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("a1b2", Set.of("a1b2", "a1B2", "A1b2", "A1B2")),
                Arguments.of("3z4", Set.of("3z4", "3Z4"))
        );
    }
}