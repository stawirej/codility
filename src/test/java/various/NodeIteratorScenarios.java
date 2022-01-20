package various;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

// Implement NodeIterator class which allows to iterate through a tree level by level.
//
//            _    A
//       /         |    \
//     B           C      D       ->  A B C D E F G H I
//   /   \     /   |   \≠≠≠≠
//  E     F   G    H     I

//    A
//    - children
//    B C D
//    - children
//    - B
//    C D E F
//    C
//    children C
//    D E F G H
//
//    E F G H I
//
//
//          A
//       /
//     B       -> A B D E
//   /   \
//  D     E
//



final class NodeIteratorScenarios {

    @Test
    void iterate_through_nodes() {
        // Given
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        b.addChild(d);
        b.addChild(e);
        c.addChild(f);
        c.addChild(g);
        a.addChild(b);
        a.addChild(c);

        var nodeIterator = new various.NodeIterator(a);

        List<String> nodeNames = new ArrayList<>();
        // When
        while (nodeIterator.hasNext()) {
            Node node = nodeIterator.next();
            System.out.println("node = " + node);
            nodeNames.add(node.getName());
        }

        // Then
        then(nodeNames)
            .containsSequence("A", "B", "C", "D", "E", "F", "G");
    }
}
