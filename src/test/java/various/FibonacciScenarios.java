package various;

import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.params.provider.Arguments.of;
import static various.Fibonacci.fib;
import static various.Fibonacci.fibIterative;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

final class FibonacciScenarios {

    private static List<Arguments> cases() {
        return asList(
            of(0, 0),
            of(1, 1),
            of(2, 1),
            of(3, 2),
            of(12, 144)
                     );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void fib_recursive(int N, int expectedNumber) {
        // When
        int number = fib(N);

        // Then
        then(number).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @MethodSource("cases")
    void fib_iterative(int N, int expectedNumber) {
        // When
        int number = fibIterative(N);

        // Then
        then(number).isEqualTo(expectedNumber);
    }
}
