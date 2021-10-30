package codility.dynamicprogramming;

final class NumberSolitaire {

    public static int solution(int[] A) {

        int maxSum = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] > 0) {
                maxSum += A[i];
                continue;
            }

            if (A[i] < 0) {
                long maxDiceStep = maxDiceStep(A.length, i - 1);
                int max = A[i];

                int maxIndex = i;
                for (int j = i; j < i + maxDiceStep; j++) {
                    if (A[j] > 0) {
                        max = A[j];
                        maxIndex = j;
                        break;
                    }
                    if (A[j] >= max) {
                        max = A[j];
                        maxIndex = j;
                    }
                }

                if (maxDiceStep < 6 && max < 0) {
                    max = A[A.length - 1];
                    maxIndex = A.length - 1;
                }

                maxSum += max;
                i = maxIndex;
            }
        }

        return maxSum;
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
