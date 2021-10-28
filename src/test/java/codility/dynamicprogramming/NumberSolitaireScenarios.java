package codility.dynamicprogramming;

import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.params.provider.Arguments.of;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

final class NumberSolitaireScenarios {

    private static List<Arguments> cases() {
        return asList(
            of(new int[] {1, -2, 0, 9, -1, -2}, 8),
            of(new int[] {1, -2, 0, 9, -1, -2, 4}, 14),
            of(new int[] {1, 2}, 3),
            of(new int[] {1, 3, 5}, 9),
            of(new int[] {1, -1, -1, -1, -1, -1, -9, -1, -1, -1, -1, -1, -9, -1}, -2),
            of(new int[] {-1, -1, -1, -1, -1, -1, -9, -1, -1, -1, -1, -1, -9, -1}, -4),
            of(new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, -3),
            of(new int[] {1, -2, 4, 3, -1, -3, -7, 4, -9}, 3)
                     );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void valid_cases(int[] A, int expectedMaxSum) {
        // When
        int maxSum = NumberSolitaire.solution(A);

        // Then
        then(maxSum).isEqualTo(expectedMaxSum);
    }

}
