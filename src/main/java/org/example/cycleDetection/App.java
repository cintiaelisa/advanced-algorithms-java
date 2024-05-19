package org.example.cycleDetection;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        VertexCd v0 = new VertexCd("A");
        VertexCd v1 = new VertexCd("B");
        VertexCd v2 = new VertexCd("C");
        VertexCd v3 = new VertexCd("D");
        VertexCd v4 = new VertexCd("E");
        VertexCd v5 = new VertexCd("F");

        // Handle the connections
        v5.addNeighbor(v0);
        v0.addNeighbor(v4);
        v0.addNeighbor(v2);
        v4.addNeighbor(v5); // Cycle
        v2.addNeighbor(v1);
        v2.addNeighbor(v3);

        List<VertexCd> graph = new ArrayList<>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        CycleDetection algorithm = new CycleDetection();
        algorithm.detectCycles(graph);
    }
}
