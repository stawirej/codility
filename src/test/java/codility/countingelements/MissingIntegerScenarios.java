package codility.countingelements;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Created by Peter on 2015-05-30.
 */
public class MissingIntegerScenarios {

    @Test
    public void shouldPassExample() {
        // Given
        final int[] A = {1, 3, 6, 4, 1, 2};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(5);
    }

    @Test
    public void shouldPassSimpleExample2() {
        // Given
        final int[] A = {-3, 1, 3, 10, 6, 4, -2, 1, 2};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(5);
    }

    @Test
    public void shouldPassExample3() {
        // Given
        final int[] A = {1};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(2);
    }

    @Test
    public void shouldPassExample4() {
        // Given
        final int[] A = {2};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(1);
    }

    @Test(timeout = 5000)
    public void shouldFindLastMaximumElement() {
        // Given
        final int[] A = IntStream.rangeClosed(-50000, 50000).toArray();
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(50001);
    }

    @Test(timeout = 5000)
    public void shouldFindLastMaximumElementForOnlyPositives() {
        // Given
        final int[] A = IntStream.rangeClosed(1, 100000).toArray();
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(100001);
    }

    @Test(timeout = 5000)
    public void shouldFindMissingInMaximumRange() {
        // Given
        final int[] A = IntStream.rangeClosed(1, 100000).toArray();
        A[89999] = -1;
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(90000);
    }

    @Test
    public void shouldReturnOneWhenAllNegatives() {
        // Given
        final int[] A = {-2, -3};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(1);
    }

    @Test
    public void shouldPassForSingleElement() {
        // Given
        final int[] A = {1, 1, 1, 1, 1};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(2);
    }

    @Test
    public void shouldPassForSingleElement2() {
        // Given
        final int[] A = {2, 2, 2, 2};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(1);
    }

    @Test
    public void shouldPassForSingleElement3() {
        // Given
        final int[] A = {3, 3, 3, 3};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(1);
    }

    @Test
    public void shouldPassExtremeMinAndMax() {
        // Given
        final int[] A = {-2147483648, 2147483647};
        final MissingInteger missingInteger = new MissingInteger();

        // When
        final int missing = missingInteger.solution(A);

        // Then
        assertThat(missing).isEqualTo(1);
    }
}
