package various;

final class MergeSort {

    public static void sort(int[] input) {

        int[] output = new int[input.length];
        sort(input, output, 0, input.length - 1);

    }

    private static void sort(int[] input, int[] output, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(input, output, low, mid);
        sort(input, output, mid + 1, high);
        merge(input, output, low, high, mid);
    }

    private static void merge(final int[] input, final int[] output, final int low, final int high, final int mid) {

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {

            if (i <= mid && j <= high) {
                if (input[i] < input[j]) {
                    output[k] = input[i];
                    i++;
                } else {
                    output[k] = input[j];
                    j++;
                }
            } else if (j > high && i <= mid) {
                output[k] = input[i];
                i++;
            } else if (i > mid && j <= high) {
                output[k] = input[j];
                j++;
            }
        }

        for (int n = low; n <= high; n++) {
            input[n] = output[n];
        }
    }

}
