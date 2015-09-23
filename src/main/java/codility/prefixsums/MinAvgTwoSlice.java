package codility.prefixsums;

public class MinAvgTwoSlice {

    public int solution(final int[] A) {
        float smallestAverage = Integer.MAX_VALUE;
        float previousAverage = Integer.MAX_VALUE;
        int sliceStartIndex = 0;
        int startIndex = 0;
        int endIndex = 1;

        while (startIndex < A.length - 1) {
            final float currentAverage = getAverageForRange(A, startIndex, endIndex);
            if (currentAverage < previousAverage) {
                if (smallestAverage > currentAverage) {
                    smallestAverage = currentAverage;
                    sliceStartIndex = startIndex;
                }
                endIndex = endIndex >= A.length - 1 ? A.length - 1 : endIndex + 1;
            } else {
                startIndex++;
                endIndex = startIndex + 1;
            }
            previousAverage = currentAverage;
        }
        return sliceStartIndex;
    }

    private float getAverageForRange(final int[] A, final int startIndex, final int endIndex) {
        int counter = 0;
        float sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += A[i];
            counter++;
        }
        return sum / counter;
    }
}
