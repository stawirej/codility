package codility.prefixsums;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class CountDivScenarios {

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final int A = 6;
        final int B = 11;
        final int K = 2;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(3);
    }

    @Test
    public void shouldPassSimpleSecondExample() {
        // Given
        final int A = 11;
        final int B = 345;
        final int K = 17;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(20);
    }

    @Test(timeout = 5000)
    public void shouldPassForLargeKExample() {
        // Given
        final int A = 0;
        final int B = 2_000_000_000;
        final int K = 2_000_000_000;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(2);
    }

    @Test(timeout = 5000)
    public void shouldPassForSmallKExample() {
        // Given
        final int A = 0;
        final int B = 2_000_000_000;
        final int K = 2;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(1_000_000_001);
    }

    @Test
    public void shouldPassForSameRangeExample() {
        // Given
        final int A = 0;
        final int B = 0;
        final int K = 2;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(1);
    }

    @Test
    public void shouldPassForSameNotZeroRangeExample() {
        // Given
        final int A = 1;
        final int B = 1;
        final int K = 2;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(0);
    }

    @Test
    public void shouldPassForSameRangeStartingWithZeroExample() {
        // Given
        final int A = 0;
        final int B = 1;
        final int K = 1;
        final CountDiv countDiv = new CountDiv();

        // When
        final int divisibleCount = countDiv.solution(A, B, K);

        // Then
        assertThat(divisibleCount).isEqualTo(2);
    }
}
