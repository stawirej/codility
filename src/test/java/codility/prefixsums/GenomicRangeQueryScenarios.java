package codility.prefixsums;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class GenomicRangeQueryScenarios {

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final String S = "CAGCCTA";
        final int[] P = {2, 5, 0};
        final int[] Q = {4, 5, 6};
        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        assertThat(solution).containsSequence(2, 4, 1).hasSize(3);
    }
}
