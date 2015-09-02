package codility.countingelements;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Peter on 2015-05-15.
 */
public class FrogRiverOne {

    public int solution(final int X, final int[] A) {
        final Set<Integer> expectedLeafs = IntStream.rangeClosed(1, X).boxed().collect(Collectors.toSet());

        for (int i = 0; i < A.length; i++) {
            expectedLeafs.remove(A[i]);
            if (expectedLeafs.isEmpty()) {
                return i;
            }
        }

        return -1;
    }
}
