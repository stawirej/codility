package codility.countingelements;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * Created by Peter on 2015-05-15.
 */
public class FrogRiverOneScenarios {

    @Test
    public void shouldBeAbleToJumpImmediatelyForOneElementList() {
        // Given
        final int A[] = new int[] {1};
        final int X = 1;
        final FrogRiverOne frogRiverOne = new FrogRiverOne();

        // When
        final int time = frogRiverOne.solution(X, A);

        // Then
        assertThat(time).isEqualTo(0);
    }

    @Test
    public void shouldBeAbleToJumpForExampleList() {
        // Given
        final int A[] = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
        final int X = 5;
        final FrogRiverOne frogRiverOne = new FrogRiverOne();

        // When
        final int time = frogRiverOne.solution(X, A);

        // Then
        assertThat(time).isEqualTo(6);
    }

    @Test
    public void shouldNotBeAbleToJump() {
        // Given
        final int A[] = new int[] {1, 3, 1, 4, 2, 3, 2, 4};
        final int X = 5;
        final FrogRiverOne frogRiverOne = new FrogRiverOne();

        // When
        final int time = frogRiverOne.solution(X, A);

        // Then
        assertThat(time).isEqualTo(-1);
    }

}
