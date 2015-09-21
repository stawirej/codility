package codility.prefixsums;

public class CountDiv {

    public int solution(final int A, final int B, final int K) {
        final int newA = A - (A % K);
        final int newB = B - (B % K);

        final int divisibleCount = (newB - newA) / K;

        if (A % K == 0) {
            return divisibleCount + 1;
        } else {
            return divisibleCount;
        }
    }
}