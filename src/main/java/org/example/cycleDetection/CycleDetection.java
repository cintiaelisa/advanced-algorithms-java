package org.example.cycleDetection;

import java.util.List;

public class CycleDetection {

    public void detectCycles(List<VertexCd> graph) {
        // there are multiple independent clusters
        for (VertexCd vertex : graph) {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    private void dfs(VertexCd vertex) {

        vertex.setBeingVisited(true);

        for (VertexCd v : vertex.getNeighbors()) {
            if (v.isBeingVisited()) {
                System.out.println("Backward edge. There is a cycle. From " + v +" to " + vertex);
                return;
            }

            if (!v.isVisited()) {
                v.setVisited(true);
                dfs(v);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}
