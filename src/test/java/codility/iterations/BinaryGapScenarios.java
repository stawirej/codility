package codility.iterations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryGapScenarios {

    private final int N;
    private final int result;

    public BinaryGapScenarios(final int N, final int result) {
        this.N = N;
        this.result = result;
    }

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final BinaryGap binaryGap = new BinaryGap();

        // When
        final int solution = binaryGap.solution(N);

        // Then
        assertThat(solution).isEqualTo(result);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(new Object[][] {{9, 2}, {529, 4}, {20, 1}, {15, 0}});
    }

}
