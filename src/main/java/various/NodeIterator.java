package various;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

final class NodeIterator implements Iterator<Node> {

    private final Queue<Node> nodes;

    public NodeIterator(final Node rootNode) {

        nodes = new PriorityQueue<>();
        nodes.add(rootNode);
    }

    @Override
    public boolean hasNext() {

        if (!nodes.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Node next() {

        if (nodes.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = nodes.poll();
        nodes.addAll(node.children());
        return node;
    }
}
