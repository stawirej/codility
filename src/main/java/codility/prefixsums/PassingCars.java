package codility.prefixsums;

import java.util.stream.IntStream;

/**
 * Created by Peter on 2015-05-30.
 */
public class PassingCars {

    public int solution(final int[] A) {
        int onesBeforeSum = 0;
        int pairsCount = 0;

        final long onesCount = IntStream.of(A).filter(this::isEqualOne).count();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                pairsCount += onesCount - onesBeforeSum;
                if (pairsCount > 1000000000) {
                    return -1;
                }
            } else {
                onesBeforeSum++;
            }
        }

        return pairsCount;
    }

    private boolean isEqualOne(final int value) {
        return value == 1;
    }
}
