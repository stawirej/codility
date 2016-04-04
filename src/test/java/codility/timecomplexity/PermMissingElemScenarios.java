package codility.timecomplexity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PermMissingElemScenarios {

    @Test
    public void shouldReturnMissingForExampleTest() {
        // Given
        int[] A = new int[] {2, 3, 1, 5};
        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(4);
    }

    @Test
    public void shouldReturnOneForEmptyList() {
        // Given
        int[] A = new int[] {};
        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(1);
    }

    @Test
    public void shouldReturnOneForOneElementList() {
        // Given
        int[] A = new int[] {2};
        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(1);
    }

    @Test
    public void shouldReturnTwoForOneElementList() {
        // Given
        int[] A = new int[] {1};
        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(2);
    }

    @Test
    public void shouldReturnMissingForBigList() {
        // Given
        int maxSize = 100000;
        int[] A = new int[maxSize];
        for (int i = 1; i <= maxSize; i++) {
            A[i - 1] = i;
        }

        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(100001);
    }

    @Test
    public void shouldMissingMiddleValueForBigList() {
        // Given
        int maxSize = 100000;
        int[] A = new int[maxSize];
        for (int i = 0, value = 1; i < maxSize; i++, value++) {
            if (value == 10001) {
                value++;
            }
            A[i] = value;
        }

        PermMissingElem missingElem = new PermMissingElem();

        // When
        int missingElement = missingElem.solution(A);

        // Then
        assertThat(missingElement).isEqualTo(10001);
    }

}
