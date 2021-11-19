package coursera.assignments;

import java.util.Objects;

final class Edge {

    private final long fromVertex;
    private final long toVertex;

    public Edge(long fromVertex, long toVertex) {

        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
    }

    public long fromVertex() {
        return fromVertex;
    }

    public long toVertex() {
        return toVertex;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Edge edge = (Edge)o;
        return (fromVertex == edge.fromVertex && toVertex == edge.toVertex) ||
               (fromVertex == edge.toVertex && toVertex == edge.fromVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromVertex, toVertex);
    }

    public boolean isSelfLoop() {

        return fromVertex == toVertex;
    }

    @Override
    public String toString() {
        return "Edge(" + fromVertex + "," + toVertex + ")";
    }
}
