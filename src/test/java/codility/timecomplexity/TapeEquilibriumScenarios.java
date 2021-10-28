package codility.timecomplexity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TapeEquilibriumScenarios {

    @Test
    public void shouldPassExampleTest() {
        // Given
        final TapeEquilibrium equilibrium = new TapeEquilibrium();
        final int[] A = new int[] {3, 1, 2, 4, 3};

        // When
        final int minimalDifference = equilibrium.solution(A);

        // Then
        assertThat(minimalDifference).isEqualTo(1);
    }

    @Test
    public void shouldReturnMinimalDifferenceForTwoElementList() {
        // Given
        final TapeEquilibrium equilibrium = new TapeEquilibrium();
        final int[] A = new int[] {2, 4};

        // When
        final int minimalDifference = equilibrium.solution(A);

        // Then
        assertThat(minimalDifference).isEqualTo(2);
    }

    @Test
    public void shouldReturnMinimalDifferenceForBigList() {
        // Given
        final TapeEquilibrium equilibrium = new TapeEquilibrium();
        final int N = 100000;
        final int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = 1000;
        }

        // When
        final int minimalDifference = equilibrium.solution(A);

        // Then
        assertThat(minimalDifference).isEqualTo(0);
    }
}
