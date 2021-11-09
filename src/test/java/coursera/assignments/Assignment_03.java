package coursera.assignments;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

final class Assignment_03 {

    @Test
    void simple() {
        // Given
        int[] A = new int[] {3, 8, 2, 5, 1, 4, 7, 6};
        int[] expected = new int[A.length];
        System.arraycopy(A, 0, expected, 0, A.length);
        Arrays.sort(expected);

        // When
        QuickSort.quickSort(A, 0, A.length - 1);

        // Then
        then(A).containsSequence(expected);
    }

    @Test
    void simple_median() {
        // Given
        int[] A = new int[] {3, 8, 2, 5, 1, 4, 7, 6};
        int[] expected = new int[A.length];
        System.arraycopy(A, 0, expected, 0, A.length);
        Arrays.sort(expected);

        // When
        QuickSort.quickSort_median(A, 0, A.length - 1);

        // Then
        then(A).containsSequence(expected);
    }

    @Test
    void comparisions_case_1() throws FileNotFoundException {
        // Given
        List<Integer> integers = new ArrayList<Integer>();
        Scanner scan = new Scanner(new File("scenarios/coursera/assignments/QuickSort.txt"));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            integers.add(Integer.parseInt(line));
        }
        int[] A = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            A[i] = integers.get(i);
        }

        int[] expected = new int[A.length];
        System.arraycopy(A, 0, expected, 0, A.length);
        Arrays.sort(expected);

        // When
        QuickSort.quickSort(A, 0, A.length - 1);

        // Then
        then(A).containsSequence(expected);
        System.out.println("QuickSort.counter = " + QuickSort.counter);
        //left 162085
    }

    @Test
    void comparisions_case_2() throws FileNotFoundException {
        // Given
        List<Integer> integers = new ArrayList<Integer>();
        Scanner scan = new Scanner(new File("scenarios/coursera/assignments/QuickSort.txt"));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            integers.add(Integer.parseInt(line));
        }
        int[] A = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            A[i] = integers.get(i);
        }

        int[] expected = new int[A.length];
        System.arraycopy(A, 0, expected, 0, A.length);
        Arrays.sort(expected);

        // When
        QuickSort.quickSort_right(A, 0, A.length - 1);

        // Then
        then(A).containsSequence(expected);
        System.out.println("QuickSort.counter = " + QuickSort.counter);
        //right 164123
    }

    @Test
    void comparisions_case_3() throws FileNotFoundException {
        // Given
        List<Integer> integers = new ArrayList<Integer>();
        Scanner scan = new Scanner(new File("scenarios/coursera/assignments/QuickSort.txt"));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            integers.add(Integer.parseInt(line));
        }
        int[] A = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            A[i] = integers.get(i);
        }

        int[] expected = new int[A.length];
        System.arraycopy(A, 0, expected, 0, A.length);
        Arrays.sort(expected);

        // When
        QuickSort.quickSort_median(A, 0, A.length - 1);

        // Then
        then(A).containsSequence(expected);
        System.out.println("QuickSort.counter = " + QuickSort.counter);
        //right 138382
    }

    @Test
    void median_1() {
        // Given
        int[] A = new int[] {8, 2, 4, 5, 7, 1};

        // When
        int medianOfThreeIndex = QuickSort.median(A, 0, A.length - 1);

        // Then
        then(medianOfThreeIndex).isEqualTo(2);
        then(A[medianOfThreeIndex]).isEqualTo(4);
    }

    @Test
    void median_2() {
        // Given
        int[] A = new int[] {8, 1};

        // When
        int medianOfThreeIndex = QuickSort.median(A, 0, A.length - 1);

        // Then
        then(medianOfThreeIndex).isEqualTo(1);
        then(A[medianOfThreeIndex]).isEqualTo(1);
    }

    @Test
    void median_3() {
        // Given
        int[] A = new int[] {4, 5, 6, 7};

        // When
        int medianOfThreeIndex = QuickSort.median(A, 0, A.length - 1);

        // Then
        then(medianOfThreeIndex).isEqualTo(1);
        then(A[medianOfThreeIndex]).isEqualTo(5);
    }

    @Test
    void median_4() {
        // Given
        int[] A = new int[] {3, 8, 2, 5, 1, 4, 7, 6};

        // When
        int medianOfThreeIndex = QuickSort.median(A, 0, A.length - 1);

        // Then
        then(medianOfThreeIndex).isEqualTo(3);
        then(A[medianOfThreeIndex]).isEqualTo(5);
    }
}
