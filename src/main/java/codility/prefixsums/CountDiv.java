package codility.prefixsums;

public class CountDiv {

    public int solution(final int A, final int B, final int K) {
        final int newA = A - (A % K);
        final int newB = B + (B % K);

        if (K > B && B != 0) {
            return 0;
        } else if (A == 0 || (A == B && A % K == 0)) {
            return ((newB - newA) / K) + 1;
        } else {
            return ((newB - newA) / K);
        }
    }
}
