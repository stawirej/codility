package coursera.assignments;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

final class Assignment_04 {

    @Test
    void min_cuts_simple() {
        // Given
        var graph = new Graph("scenarios/coursera/assignments/graph1.txt");

        // When
        var minCut = graph.minCut();

        // Then
        System.out.println(minCut);
    }

    @Test
    void min_cuts() {
        // Given
        var graph = new Graph("scenarios/coursera/assignments/kargerMinCut.txt");

        // When
        var minCut = graph.minCut();

        // Then
        then(minCut).isEqualTo(17);
    }

    @Test
    void vertices_count() {
        // Given
        var graph = new Graph("scenarios/coursera/assignments/graph1.txt");

        // When
        var count = graph.verticesCount();

        // Then
        then(count).isEqualTo(4);
    }

    @Test
    void self_loop_edge() {
        // When
        var edge = new Edge(1, 1);

        // Then
        then(edge.isSelfLoop()).isTrue();
    }

    @Test
    void not_self_loop_edge() {
        // When
        var edge = new Edge(1, 2);

        // Then
        then(edge.isSelfLoop()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(
        {"1, 2, 1, 2, true",
         "1, 2, 2, 1, true",
         "2, 2, 2, 2, true",
         "2, 2, 3, 2, false"
        }
    )
    void equal_edge(int fromVertex1, int toVertex1, int fromVertex2, int toVertex2, boolean result) {
        // Given
        var edge1 = new Edge(fromVertex1, toVertex1);
        var edge2 = new Edge(fromVertex2, toVertex2);

        // When
        var equal = edge1.equals(edge2);

        // Then
        then(equal).isEqualTo(result);
    }

}
