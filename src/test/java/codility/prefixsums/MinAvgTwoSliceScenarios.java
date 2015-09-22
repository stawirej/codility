package codility.prefixsums;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class MinAvgTwoSliceScenarios {

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final int[] A = {4, 2, 2, 5, 1, 5, 8};
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(1);
    }

    @Test
    public void shouldPassSecondSimpleExample() {
        // Given
        final int[] A = {-3, -5, -8, -4, -10};
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(2);
    }

    @Test
    public void shouldPassThirdSimpleExample() {
        // Given
        final int[] A = {5, 6, 3, 4, 9};
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(2);
    }

    @Test
    public void shouldPassForTwoElements() {
        // Given
        final int[] A = {-10, 10};
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(0);
    }

    @Test
    public void shouldPassExampleWithNegativeValues() {
        // Given
        final int[] A = {30, 30, -10, 14, 2, 2, -6, -2, 8};
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(6);
    }

    @Test
    public void shouldPassForMaxSize() {
        // Given
        final int[] A = new int[100_000];
        Arrays.fill(A, 10_000);
        final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        // When
        final int startPosition = minAvgTwoSlice.solution(A);

        // Then
        assertThat(startPosition).isEqualTo(0);
    }
}