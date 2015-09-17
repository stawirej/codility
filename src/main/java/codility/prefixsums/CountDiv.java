package codility.prefixsums;

public class CountDiv {

    public int solution(final int A, final int B, final int K) {
        final int newA = A - (A % K);
        final int newB = B + (B % K);

        if (K > B && A > 0) {
            return 0;
        } else if ((K > B && A == 0) || newA == 0) {
            return ((newB - newA) / K) + 1;
        } else {
            return ((newB - newA) / K);
        }
    }
}
