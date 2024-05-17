package org.example.DepthFirstSearch;

import org.example.model.Vertex;

import java.util.List;

public class DepthFirstSearchRecursion {

    public void dfs(List<Vertex> vertexList) {

        // it may happen that we have independent clusters
        for(Vertex vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex vertex) {
        System.out.println(vertex);

        for (Vertex v : vertex.getNeighbors()) {
            if(!v.isVisited()) {
                v.setVisited(true);
                dfsHelper(v);
            }
        }
    }
}
