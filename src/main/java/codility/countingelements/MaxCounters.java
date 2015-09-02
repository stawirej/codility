package codility.countingelements;

/**
 * Created by Peter on 2015-05-17.
 */
public class MaxCounters {

    public int[] solution(final int N, final int[] A) {
        final int[] counters = new int[N];
        final int counterExceeded = N + 1;
        int currentMaxCounter = 0;
        int previousMaxCounter = 0;
        int counterIndex;

        for (int i = 0; i < A.length; i++) {
            counterIndex = A[i] - 1;
            if (A[i] == counterExceeded) {
                previousMaxCounter = currentMaxCounter;
            } else {
                if (counters[counterIndex] < previousMaxCounter) {
                    counters[counterIndex] = previousMaxCounter + 1;
                } else {
                    counters[counterIndex]++;
                }
                if (currentMaxCounter < counters[counterIndex]) {
                    currentMaxCounter = counters[counterIndex];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < previousMaxCounter) {
                counters[i] = previousMaxCounter;
            }
        }

        return counters;
    }
}
