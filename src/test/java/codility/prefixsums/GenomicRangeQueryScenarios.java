package codility.prefixsums;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Arrays;

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
    public void shouldPassMultipleSameCharacter() {
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

    @Test(timeout = 7_000)
    public void shouldPassMAximumLengthSameCharacter() {
        // Given
        final StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100_000; i++) {
            buffer.append('G');
        }
        final String S = buffer.toString();

        final int[] P = new int[50_000];
        final int[] Q = new int[50_000];
        Arrays.fill(P, 0);
        Arrays.fill(Q, 99_000);

        final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

        // When
        final int[] solution = genomicRangeQuery.solution(S, P, Q);

        // Then
        final int[] expected = new int[50_000];
        Arrays.fill(expected, 3);
        then(solution).containsSequence(expected).hasSize(50_000);
    }
}
