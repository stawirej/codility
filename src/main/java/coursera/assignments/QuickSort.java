package coursera.assignments;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

final class QuickSort {

    public static long counter = 0;

    public static void quickSort(int[] A, int left, int right) {

        if (left >= 0 && right >= 0 && left < right) {
            int i = partition(A, left, right);
            quickSort(A, left, i - 1);
            quickSort(A, i + 1, right);
        }
    }

    public static void quickSort_right(int[] A, int left, int right) {

        if (left >= 0 && right >= 0 && left < right) {
            int i = partition_right(A, left, right);
            quickSort_right(A, left, i - 1);
            quickSort_right(A, i + 1, right);
        }
    }

    public static void quickSort_median(int[] A, int left, int right) {

        if (left >= 0 && right >= 0 && left < right) {
            int i = partition_median(A, left, right);
            quickSort_median(A, left, i - 1);
            quickSort_median(A, i + 1, right);
        }
    }

    private static int choosePivot(final int[] A, final int n) {

        return A[0];
    }

    private static int partition(int[] A, int left, int right) {

        int pivot = A[left];
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            counter++;
            // if A[j] > pivot do nothing
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, left, i - 1);
        return i - 1;
    }

    private static int partition_right(int[] A, int left, int right) {

        // swap firdt and last to use last element as pivot but in 'old' implementation
        swap(A, left, right);

        int pivot = A[left];
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            counter++;
            // if A[j] > pivot do nothing
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, left, i - 1);
        return i - 1;
    }

    private static int partition_median(int[] A, int left, int right) {

        int medianOfThreeIndex = median(A, left, right);
        // swap firdt and 'median of three' to use last element as pivot but in 'old' implementation
        swap(A, left, medianOfThreeIndex);

        int pivot = A[left];

        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            counter++;
            // if A[j] > pivot do nothing
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, left, i - 1);
        return i - 1;
    }

    private static void swap(int[] A, int i, int j) {

        int a = A[i];
        int b = A[j];
        A[i] = b;
        A[j] = a;
    }

    public static int median(final int[] A, final int left, final int right) {

        int median;
        int medianValue;

        median = ((right - left) / 2) + left;
        int leftValue = A[left];
        int rightValue = A[right];
        if (right - left == 1) {
            medianValue = 0;
        } else {
            medianValue = A[median];
        }
        int sortedMedianValue;

        Map<Integer, Integer> map = Map.of(leftValue, left, rightValue, right, medianValue, median);
        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        if (collect.size() == 2) {
            sortedMedianValue = collect.get(0);
        } else {
            sortedMedianValue = collect.get(1);
        }

        return map.get(sortedMedianValue);
    }
}
