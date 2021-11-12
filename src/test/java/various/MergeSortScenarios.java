package various;

import static java.util.Arrays.asList;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.params.provider.Arguments.of;
import static various.MergeSort.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;

final class MergeSortScenarios {

    private static List<Arguments> cases() {
        return asList(
            of(new int[] {1}, new int[] {1}),
            of(new int[] {2, 1}, new int[] {1, 2}),
            of(new int[] {3, 2, 1}, new int[] {1, 2, 3}),
            of(new int[] {4, 3, 2, 1}, new int[] {1, 2, 3, 4}),
            of(new int[] {5, 3, 8, 9, 1, 7, 0, 2, 6, 4}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
                     );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void merge_sort(int[] input, int[] output) {
        // When
        sort(input);

        // Then
        then(input).isEqualTo(output);
    }

}
