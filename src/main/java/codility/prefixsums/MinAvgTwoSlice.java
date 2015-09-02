package codility.prefixsums;

public class MinAvgTwoSlice {

    public int solution(final int[] A) {
        int smallestAverage = Integer.MAX_VALUE;
        int sliceStartIndex = 0;
        for (int i = 1; i < A.length; i++) {
            final int pairAvarage = (A[i - 1] + A[i]) / 2;
            if (smallestAverage > pairAvarage) {
                smallestAverage = pairAvarage;
                sliceStartIndex = i - 1;
            }
        }
        return sliceStartIndex;
    }
}
