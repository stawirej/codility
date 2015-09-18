package codility.prefixsums;

public class CountDiv {

    public int solution(final int A, final int B, final int K) {

        final int newA = A % K == 0 ? A : A - (A % K);
        final int newB = B % K == 0 ? B : B + (B % K);

        // final int result = (int)Math.ceil(((double)B - (double)A) / (double)K);
        final int result = (int)Math.ceil(((double)B - A) / K);

        if (K > B && B != 0) {
            return 0;
        } else if (A == newA && B == newB) {
            return result + 1;
        } else if (A >= 0) {
            return result;
        } else {
            return result - 1;
        }

        // final int newA = A - (A % K);
        // final int newB = B + (B % K);
        //
        // final int result = (newB - newA) / K;
        //
        // if (K > B && B != 0) {
        // return 0;
        // } else if (A == newA && B == newB) {
        // return result + 1;
        // } else if (newA != A && newA % K == 0 && newB != B && newB % K == 0) {
        // return result - 1;
        // } else {
        // return result;
        // }
    }
}