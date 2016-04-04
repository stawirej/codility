package codility.countingelements;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Created by Peter on 2015-05-17.
 */
public class MaxCountersScenarios {

    @Test
    public void shouldPassExample() {
        // Given
        final MaxCounters maxCounters = new MaxCounters();
        final int N = 5;
        final int[] A = IntStream.of(3, 4, 4, 6, 1, 4, 4).toArray();

        // When
        final int[] counters = maxCounters.solution(N, A);

        // Then
        assertThat(counters).containsSequence(3, 2, 2, 4, 2).hasSize(5);
    }

    @Test
    public void shouldPassExample2() {
        // Given
        final int[] A = {1, 2, 3, 2, 4, 6, 1, 4, 5, 6, 5, 2};
        final int N = 5;
        final MaxCounters maxCounters = new MaxCounters();

        // When
        final int[] counters = maxCounters.solution(N, A);

        // Then
        assertThat(counters).containsSequence(3, 4, 3, 3, 4).hasSize(N);
    }

    @Test(timeout = 10000)
    public void shouldProcessFastAllMaxCounterOperations() {
        // Given
        final int N = 100000;
        final int[] A = new int[N];
        Arrays.fill(A, N + 1);
        final MaxCounters maxCounters = new MaxCounters();

        // When
        final int[] counters = maxCounters.solution(N, A);

        // Then
        assertThat(counters).containsOnly(0).hasSize(N);
    }
}
