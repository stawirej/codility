package codility.timecomplexity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * /** Created by Peter on 2015-05-02.
 */
public class FrogJmpScenarios {

    @Test
    public void shouldNoJumpWhenTheSameLocation() {
        // Given
        final int X = 10;
        final int Y = X;
        final int D = 30;
        final FrogJmp frogJmp = new FrogJmp();

        // When
        final int jumpCount = frogJmp.solution(X, Y, D);

        // Then
        assertThat(jumpCount).isEqualTo(0);
    }

    @Test
    public void shouldMakeJump() {
        // Given
        final int X = 10;
        final int Y = 85;
        final int D = 30;
        final FrogJmp frogJmp = new FrogJmp();

        // When
        final int jumpCount = frogJmp.solution(X, Y, D);

        // Then
        assertThat(jumpCount).isEqualTo(3);
    }

    @Test
    public void shouldMakeBigJumps() {
        // Given
        final int X = 1;
        final int Y = 1000000000;
        final int D = 500000000;
        final FrogJmp frogJmp = new FrogJmp();

        // When
        final int jumpCount = frogJmp.solution(X, Y, D);

        // Then
        assertThat(jumpCount).isEqualTo(2);
    }
}
