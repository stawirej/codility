package codility.iterations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;

public class BinaryGapScenarios {

    private static List<Arguments> cases() {
        return Arrays.asList(of(9, 2),
                             of(529, 4),
                             of(20, 1),
                             of(15, 0));
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void shouldPassSimpleExample(int N, int result) {
        // Given
        final BinaryGap binaryGap = new BinaryGap();

        // When
        final int solution = binaryGap.solution(N);

        // Then
        assertThat(solution).isEqualTo(result);
    }
}
