package codility.countingelements;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Created by Peter on 2015-05-15.
 */
public class PermCheckScenarios {

    @Test
    public void shouldBePermutationForSimpleExample() {
        // Given
        final int A[] = new int[] {4, 1, 3, 2};
        final PermCheck permCheck = new PermCheck();

        // When
        final int isPermutation = permCheck.solution(A);

        // Then
        assertThat(isPermutation).isEqualTo(1);
    }

    @Test
    public void shouldNotBePermutationForSimpleExample() {
        // Given
        final int A[] = new int[] {4, 1, 3};
        final PermCheck permCheck = new PermCheck();

        // When
        final int isPermutation = permCheck.solution(A);

        // Then
        assertThat(isPermutation).isEqualTo(0);
    }

    @Test
    public void shouldBePermutationForBigList() {
        // Given
        final int N = 100000;
        final int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }

        final PermCheck permCheck = new PermCheck();

        // When
        final int isPermutation = permCheck.solution(A);

        // Then
        assertThat(isPermutation).isEqualTo(1);
    }

    @Test
    public void shouldNotBePermutationForBigList() {
        // Given
        final int N = 100000;
        final int A[] = new int[N];

        for (int i = 0; i < 10000; i++) {
            A[i] = i + 100000000;
        }
        for (int i = 10000, j = 1; i < N; i++, j++) {
            A[i] = j;
        }

        final PermCheck permCheck = new PermCheck();

        // When
        final int isPermutation = permCheck.solution(A);

        // Then
        assertThat(isPermutation).isEqualTo(0);
    }
}
