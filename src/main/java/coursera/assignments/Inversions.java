package coursera.assignments;

final class Inversions {

    public static long inversions(Integer[] A) {

        long inversionsCount = 0;

        for (int i = 0; i < A.length; i++) {
            System.out.println("i = " + i);
            for (int j = i; j < A.length; j++) {
                if (A[i] > A[j]) {
                    inversionsCount++;
                }
            }
        }
        return inversionsCount;
    }
}
