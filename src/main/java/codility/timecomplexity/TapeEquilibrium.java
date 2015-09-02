package codility.timecomplexity;

import java.util.ArrayList;
import java.util.List;

public class TapeEquilibrium {

    public int solution(final int[] A) {
        int difference = 100000000;
        final List<Integer> partialSumsBefore = new ArrayList<Integer>();
        final List<Integer> partialSumsAfter = new ArrayList<Integer>();

        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum += A[i];
            partialSumsBefore.add(sum);
        }

        sum = 0;
        for (int i = A.length - 1; i > 0; i--) {
            sum += A[i];
            partialSumsAfter.add(sum);
        }

        for (int i = 0, j = partialSumsAfter.size() - 1; j >= 0; i++, j--) {
            final int currentDifference = Math.abs(partialSumsBefore.get(i) - partialSumsAfter.get(j));
            difference = currentDifference < difference ? currentDifference : difference;
        }

        return difference;
    }
}
