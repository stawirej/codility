package codility.sorting;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class NumberOfDiscIntersectionsScenarios {

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final int[] A = {1, 5, 2, 1, 4, 0};
        final NumberOfDiscIntersections discIntersections = new NumberOfDiscIntersections();

        // When
        final int intersectionsCount = discIntersections.solution(A);

        // Then
        then(intersectionsCount).isEqualTo(11);
    }

    @Test
    public void shouldPassForEmptyInput() {
        // Given
        final int[] A = {};
        final NumberOfDiscIntersections discIntersections = new NumberOfDiscIntersections();

        // When
        final int intersectionsCount = discIntersections.solution(A);

        // Then
        then(intersectionsCount).isEqualTo(0);
    }

    @Test
    public void shouldPassForIdenticaValues() {
        // Given
        final int[] A = {1, 1, 1};
        final NumberOfDiscIntersections discIntersections = new NumberOfDiscIntersections();

        // When
        final int intersectionsCount = discIntersections.solution(A);

        // Then
        then(intersectionsCount).isEqualTo(3);
    }

    @Test
    public void shouldPassForOverflow() {
        // Given
        final int[] A = {1, 2147483647, 0};
        final NumberOfDiscIntersections discIntersections = new NumberOfDiscIntersections();

        // When
        final int intersectionsCount = discIntersections.solution(A);

        // Then
        then(intersectionsCount).isEqualTo(2);
    }
}