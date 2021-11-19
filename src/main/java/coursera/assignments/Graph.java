package coursera.assignments;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

final class Graph {

    private final String adjacencyListFilePath;
    private List<Edge> edges;
    private long maxVertex;

    public Graph(final String adjacencyListFilePath) {

        this.adjacencyListFilePath = adjacencyListFilePath;
        reloadGraph();
    }

    private void reloadGraph() {
        try {
            edges = new ArrayList<>();

            Scanner scan = new Scanner(new File(adjacencyListFilePath));
            while (scan.hasNextLine()) {
                var line = scan.nextLine();
                var splited = line.split("\\s+");
                var fromVertex = Long.parseLong(splited[0]);

                for (int i = 1; i < splited.length; i++) {
                    var toVertex = Long.parseLong(splited[i]);
                    var edge = new Edge(fromVertex, toVertex);

                    updateMaxVertex(fromVertex, toVertex);

                    if (!edges.contains(edge)) {
                        edges.add(edge);
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private void updateMaxVertex(final long fromVertex, final long toVertex) {

        if (maxVertex < fromVertex) {
            maxVertex = fromVertex;
        }

        if (maxVertex < toVertex) {
            maxVertex = toVertex;
        }
    }

    public int minCut() {

        int minCuts = Integer.MAX_VALUE;
        for (int i = 0; i < 1000; i++) {
            System.out.println("Attempt = " + i);

            reloadGraph();

            while (verticesCount() > 2) {

                var randomEdge = selectRandomEdge();
                edges = merge(randomEdge);
                edges = removeSelfLoops();
            }

            int currentMinCuts = edges.size();

            if (minCuts > currentMinCuts) {
                minCuts = currentMinCuts;
            }
        }

        return minCuts;
    }

    private List<Edge> removeSelfLoops() {

        List<Edge> noSelfLoopsEdges = new ArrayList<>();

        edges
            .forEach(edge -> {
                if (!edge.isSelfLoop()) {
                    noSelfLoopsEdges.add(edge);
                }
            });

        return noSelfLoopsEdges;
    }

    private List<Edge> merge(Edge randomEdge) {

        List<Edge> mergedEdges = new ArrayList<>();
        long vertex1 = randomEdge.fromVertex();
        long vertex2 = randomEdge.toVertex();
        maxVertex++;

        edges
            .forEach(edge -> {
                         if (edge.fromVertex() == vertex1
                             || edge.fromVertex() == vertex2
                             || edge.toVertex() == vertex1
                             || edge.toVertex() == vertex2) {

                             long fromVertex = edge.fromVertex();
                             long toVertex = edge.toVertex();

                             if (edge.fromVertex() == vertex1) {
                                 fromVertex = maxVertex;
                             }

                             if (edge.fromVertex() == vertex2) {
                                 fromVertex = maxVertex;
                             }

                             if (edge.toVertex() == vertex1) {
                                 toVertex = maxVertex;
                             }

                             if (edge.toVertex() == vertex2) {
                                 toVertex = maxVertex;
                             }

                             mergedEdges.add(new Edge(fromVertex, toVertex));

                         } else {
                             mergedEdges.add(edge);
                         }
                     }
                    );
        return mergedEdges;
    }

    private Edge selectRandomEdge() {

        Random rand = new Random();
        var edge = edges.get(rand.nextInt(edges.size()));
//        System.out.println("random edge = " + edge);
        return edge;
    }

    public int verticesCount() {

        Set<Long> vertices = new HashSet<>();

        edges.forEach(edge -> {
            vertices.add(edge.fromVertex());
            vertices.add(edge.toVertex());
        });

        return vertices.size();
    }
}
