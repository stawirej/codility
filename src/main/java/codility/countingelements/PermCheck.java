package codility.countingelements;

import java.util.Arrays;

/**
 * Created by Peter on 2015-05-15.
 */
public class PermCheck {

    private final int NOT_PERMUTATION = 0;
    private final int PERMUTATION = 1;

    public int solution(final int A[]) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i + 1 != A[i]) {
                return NOT_PERMUTATION;
            }
        }
        return PERMUTATION;
    }
}
