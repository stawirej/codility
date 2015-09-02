package codility.timecomplexity;

public class PermMissingElem {

    public int solution(int[] A) {
        long fullSum = ((long)A.length + 2) * ((long)A.length + 1) / 2;
        long aSum = 0;
        for (int i = 0; i < A.length; i++) {
            aSum += A[i];
        }
        return (int)(fullSum - aSum);
    }
}
