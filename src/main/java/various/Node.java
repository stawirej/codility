package various;

import java.util.ArrayList;
import java.util.List;

final class Node implements Comparable<Node> {

    private final String name;

    private final List<Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Node n) {
        this.children.add(n);
    }

    public String getName() {
        return name;
    }

    public List<Node> children() {
        return children;
    }

    @Override
    public String toString() {
        return "Node{name=" + name + "}";
    }

    @Override
    public int compareTo(final Node o) {
        return o.name.compareTo(name);
    }
}
