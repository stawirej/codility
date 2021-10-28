package codility.dynamicprogramming;

final class NumberSolitaire {

    public static int solution(int[] A) {

        long maxSum = A[0];
        long maxDiceStep = 0;

        for (int i = 0; i < A.length - 1; ) {

            // find max dice span
            maxDiceStep = maxDiceStep(A.length, i);

            // find max positive value in dice span
            i++;
            long offset = i - 1;
            int localMax = A[i];
            boolean onlyNegativeNumbers = true;
            for (int j = i; j < offset + maxDiceStep; j++) {
                if (A[j] > 0) {
                    localMax = A[j];
                    onlyNegativeNumbers = false;
                    i = j;
                    break;
                }
            }

            if (onlyNegativeNumbers && maxDiceStep == 6) {
                for (int j = i; j <= offset + maxDiceStep; j++) {
                    if (A[j] >= localMax) {
                        localMax = A[j];
                        i = j;
                    }
                }
            } else if (onlyNegativeNumbers && maxDiceStep < 6){
                localMax = A[A.length - 1]; //last element
                i = A.length;
            }


            // add max value
            maxSum += localMax;
            
        }

        return (int)maxSum;
    }

    private static long maxDiceStep(final long length, final long i) {
        long maxDiceStep = 0;
        if (i + 6 < length) {
            maxDiceStep = 6;
        } else if (i + 5 < length) {
            maxDiceStep = 5;
        } else if (i + 4 < length) {
            maxDiceStep = 4;
        } else if (i + 3 < length) {
            maxDiceStep = 3;
        } else if (i + 2 < length) {
            maxDiceStep = 2;
        } else if (i + 1 < length) {
            maxDiceStep = 1;
        }
        return maxDiceStep;
    }
}
