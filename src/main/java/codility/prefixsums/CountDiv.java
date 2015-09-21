package codility.prefixsums;

public class CountDiv {

    public int solution(final int A, final int B, final int K) {

        final int newA = A % K == 0 ? A : A - (A % K);
        final int newB = B % K == 0 ? B : B - (B % K);

        if (K > B && B != 0) {
            return 0;
        } else if (A % K != 0 && B % K != 0 && A >= K) {
            return (B - A) / K;
        } else if (A % K == 0 && B % K != 0) {
            return ((newB - A) / K) + 1;
        } else if (A % K != 0 && B % K == 0) {
            return (B - newA) / K;
        } else if (A == 0 && B % K != 0) {
            return newB / K;
        } else if (A == 0 && B % K == 0) {
            return (B / K) + 1;
        } else if (A < K && A % K != 0) {
            return (newB / K);
        } else if (A == B) {
            if (A % K == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (A % K == 0 & B % K == 0) {
            return ((B - A) / K) + 1;
        } else {
            return -1;
        }
    }
}