package various;

final class Fibonacci {

    public static int fib(int N) {

        if (N <= 1) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static int fibIterative(int N) {

        int previous_1 = 0;
        int previous_2 = 1;
        int current = 0;

        for (int i = 0; i < N; i++) {
            current = previous_2 + previous_1;
            previous_2 = previous_1;
            previous_1 = current;
        }

        return current;
    }
}
