package codility.prefixsums;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by Peter on 2015-05-30.
 */
public class PassingCarsScenarios {

    @Test
    public void shouldPassSimpleExample1() {
        // Given
        final int[] A = {0, 1, 0, 1, 1};
        final PassingCars passingCars = new PassingCars();

        // When
        final int carsPairsCount = passingCars.solution(A);

        // Then
        assertThat(carsPairsCount).isEqualTo(5);
    }

    @Test
    public void shouldPassSimpleExample2() {
        // Given
        final int[] A = {1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0};
        final PassingCars passingCars = new PassingCars();

        // When
        final int carsPairsCount = passingCars.solution(A);

        // Then
        assertThat(carsPairsCount).isEqualTo(18);
    }

    @Test
    public void shouldReturnNoneForAllZeros() {
        // Given
        final int[] A = {0, 0, 0, 0, 0, 0};
        final PassingCars passingCars = new PassingCars();

        // When
        final int carsPairsCount = passingCars.solution(A);

        // Then
        assertThat(carsPairsCount).isEqualTo(0);
    }

    @Test
    public void shouldReturnNoneForAllOnes() {
        // Given
        final int[] A = {1, 1, 1, 1, 1, 1};
        final PassingCars passingCars = new PassingCars();

        // When
        final int carsPairsCount = passingCars.solution(A);

        // Then
        assertThat(carsPairsCount).isEqualTo(0);
    }

    @Test
    public void shouldReturnNegativeWhenExceedRange() {
        // Given
        final int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = 0;
            } else {
                A[i] = 1;
            }
        }
        final PassingCars passingCars = new PassingCars();

        // When
        final int carsPairsCount = passingCars.solution(A);

        // Then
        assertThat(carsPairsCount).isEqualTo(-1);
    }
}
