package medium._0678_Valid_Parenthesis_String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("arguments")
    void testArguments(String s, boolean expected) {
        boolean actual = new Solution().checkValidString(s);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arguments() {

        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("(*)", true),
                Arguments.of("(*))", true),
                Arguments.of("(", false),
                Arguments.of("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())",
                        false)
        );
    }
}