package various;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

/*
Given:
0     1    2.   3.   4
 A -> B -> C -> D -> E
 |    |    |    |    |
 C    0    B    A    E

 Map<node, offset>
 A -> 2
 C -> 1
 D -> 0
 E -> 4

A copy would look like:
0     1.   2
 A1-> B1-> C1-> D1-> E1
 |    |    |    |    |
 C1   0    B1   A1   E1


root
cur = root
newroot = null
newcur = null
while (cur):
  newNode = copy(cur)
  if newcur:
    newcur.next = newnode
    newcur = newcur.next
  else:
    newroot = newcur = newnode
  cur = cur.next

 */

final class CopyScenarios {

    @Test
    void copy() {
        // Given
        var E = new Node(6, null);
        var D = new Node(5, E);
        var C = new Node(4, D);
        var B = new Node(3, C);
        var A = new Node(2, B);

        A.setAuxiliaryNode(C);
        C.setAuxiliaryNode(B);
        D.setAuxiliaryNode(A);
        E.setAuxiliaryNode(E);

        //oldNode/ newNode
        Map<Node, Node> nodes = new HashMap<>();

        Node currentNode = A;
        Node newRoot = null;
//        var rootNode = new Node(currentNode.value);
//        nodes.put(currentNode, rootNode);
        Node newCurrent = null;
        while (currentNode != null) {
            var newNode = new Node(currentNode.value);
            nodes.put(currentNode, newNode);
            if (newCurrent != null) {
                newCurrent.nextNode = newNode;
                newCurrent = newCurrent.nextNode;
                newCurrent.auxiliaryNode = currentNode.auxiliaryNode;
            } else {
                newCurrent = newNode;
                newRoot = newNode;
            }
            currentNode = currentNode.nextNode;
        }



        // When

        // Then
    }

    class Node {

        int value;
        Node nextNode;
        Node auxiliaryNode;
        public Node(final int value, final Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.auxiliaryNode = null;
        }

        public Node(final int value) {
            this.value = value;
            this.nextNode = null;
            this.auxiliaryNode = null;
        }


        public void setAuxiliaryNode(Node auxiliaryNode) {
            this.auxiliaryNode = auxiliaryNode;
        }

        public boolean hasNext() {
            if (this.nextNode != null) {
                return true;
            }
            return false;
        }

    }
}
