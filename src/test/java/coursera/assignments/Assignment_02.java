package coursera.assignments;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class Assignment_02 {

    @Test
    void inversions_1() {
        // Given
        Integer[] A = {1, 3, 5, 2, 4, 6};

        // When
        long inversionsCount = Inversions.inversions(A);

        // Then
        then(inversionsCount).isEqualTo(3);
    }

    @Test
    void inversions_2() {
        // Given
        Integer[] A = {9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0};

        // When
        long inversionsCount = Inversions.inversions(A);

        // Then
        then(inversionsCount).isEqualTo(56);
    }

    @Test
    void inversions_3() {
        // Given
        Integer[] A =
            {37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13,
             21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45};

        // When
        long inversionsCount = Inversions.inversions(A);

        // Then
        then(inversionsCount).isEqualTo(590);
    }

    @Test
    void inversions_4() {
        // Given
        Integer[] A =
            {4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84,
             6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74,
             24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36,
             57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54};

        // When
        long inversionsCount = Inversions.inversions(A);

        // Then
        then(inversionsCount).isEqualTo(2_372);
    }

    @Test
    void inversions_5() throws FileNotFoundException {
        // Given
        List<Integer> integers = new ArrayList<Integer>();
        Scanner scan = new Scanner(new File("scenarios/coursera/assignments/IntegerArray.txt"));
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            integers.add(Integer.parseInt(line));
        }

        Integer[] A = integers.toArray(new Integer[0]);

        // When
        long inversionsCount = Inversions.inversions(A);

        // Then
        then(inversionsCount).isEqualTo(2_407_905_288L);
    }
}
