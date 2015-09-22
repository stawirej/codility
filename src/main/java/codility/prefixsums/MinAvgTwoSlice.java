package codility.prefixsums;

public class MinAvgTwoSlice {

    public int solution(final int[] A) {
        float smallestAverage = Integer.MAX_VALUE;
        int sliceStartIndex = 0;

        int startIndex = 0;
        int endIndex = 1;
        float previousAvarage = Integer.MAX_VALUE;

        for (; startIndex < A.length; ) {
            final float currentAvarage = getAvarageForRange(A, startIndex, endIndex);
            if (previousAvarage < currentAvarage) {
                startIndex++;
                continue;
            }
            previousAvarage = currentAvarage;

            if (smallestAverage > currentAvarage) {
                smallestAverage = currentAvarage;
                endIndex++;
                sliceStartIndex = startIndex;
            }

        }

        // for (int i = 1; i < A.length; i++) {
        // final int pairAvarage = (A[i - 1] + A[i]) / 2;
        // if (smallestAverage > pairAvarage) {
        // smallestAverage = pairAvarage;
        // sliceStartIndex = i - 1;
        // }
        // }
        return sliceStartIndex;
    }

    private float getAvarageForRange(final int[] A, final int startIndex, final int endIndex) {
        int counter = 0;
        float sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += A[i];
            counter++;
        }
        return sum / counter;
    }
}
