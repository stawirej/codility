package codility.prefixsums;

import static org.assertj.core.api.BDDAssertions.then;

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
        then(solution).containsSequence(2, 4, 1).hasSize(3);
    }

    @Test
    public void shouldPassForDoubleCharacterString() {
        // Given
        final String S = "AC";
        final int[] P = {0, 0, 1};
        final int[] Q = {0, 1, 1};
        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        then(solution).containsSequence(1, 1, 2).hasSize(3);
    }

    @Test
    public void shouldPassForIdenticalCharacterString() {
        // Given
        final String S = "CC";
        final int[] P = {0, 0, 1};
        final int[] Q = {0, 1, 1};
        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        then(solution).containsSequence(2, 2, 2).hasSize(3);
    }

    @Test
    public void shouldPassForAnotherDoubleCharacterString() {
        // Given
        final String S = "TC"; // 42
        final int[] P = {0, 0, 1};
        final int[] Q = {0, 1, 1};
        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        then(solution).containsSequence(4, 2, 2).hasSize(3);
    }

    @Test
    public void shouldPassMultipleSameLetter() {
        // Given
        final String S = "GGGGG"; // 33333
        final int[] P = {0, 0, 1, 1, 2, 3};
        final int[] Q = {4, 1, 1, 3, 3, 3};
        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        then(solution).containsSequence(3, 3, 3, 3, 3, 3).hasSize(6);
    }
}
