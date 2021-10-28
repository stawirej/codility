package codility.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OddOccurrencesInArrayScenarios {

    @Test
    public void shouldPassSimpleExample() {
        // Given
        final int A[] = {9, 3, 9, 3, 9, 7, 9};
        final OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

        // When
        final int solution = oddOccurrencesInArray.solution(A);

        // Then
        assertThat(solution).isEqualTo(7);
    }
}
