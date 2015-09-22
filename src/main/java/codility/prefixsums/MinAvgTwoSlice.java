package codility.prefixsums;

public class MinAvgTwoSlice {

    public int solution(final int[] A) {
        float smallestAverage = Integer.MAX_VALUE;
        int sliceStartIndex = 0;

        int startIndex = 0;
        int endIndex = 1;
        float previousAvarage = Integer.MAX_VALUE;

        for (; startIndex < A.length - 1;) {
            final float currentAvarage = getAvarageForRange(A, startIndex, endIndex);
            if (previousAvarage < currentAvarage) {
                startIndex++;
                endIndex = startIndex + 1;
                continue;
            }
            if (previousAvarage == currentAvarage) {
                startIndex--;
                if (startIndex < 0) {
                    break;
                }
            }
            previousAvarage = currentAvarage;

            if (smallestAverage > currentAvarage) {
                smallestAverage = currentAvarage;
                endIndex = endIndex >= A.length - 1 ? A.length - 1 : endIndex + 1;
                sliceStartIndex = startIndex;
            }

        }

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
