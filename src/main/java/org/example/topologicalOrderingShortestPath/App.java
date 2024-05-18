package org.example.topologicalOrderingShortestPath;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<VertexSp> graph = new ArrayList<>();

        VertexSp v0 = new VertexSp("S");
        VertexSp v1 = new VertexSp("A");
        VertexSp v2 = new VertexSp("B");
        VertexSp v3 = new VertexSp("C");
        VertexSp v4 = new VertexSp("D");
        VertexSp v5 = new VertexSp("E");

        v0.addNeighbor(new Edge(v1, 1));
		v0.addNeighbor(new Edge(v3, 2));

		v1.addNeighbor(new Edge(v2, 6));

		v2.addNeighbor(new Edge(v4, 1));
		v2.addNeighbor(new Edge(v5, 2));

		v3.addNeighbor(new Edge(v1, 4));
		v3.addNeighbor(new Edge(v4, 3));

		v4.addNeighbor(new Edge(v5, 1));

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        ShortestPath algorithm = new ShortestPath(graph);
        algorithm.compute();

        for (VertexSp v : graph)
            System.out.println("Distance from s: " + v.getMinDistance() + " - " + v.getPredecessor());
    }

}
