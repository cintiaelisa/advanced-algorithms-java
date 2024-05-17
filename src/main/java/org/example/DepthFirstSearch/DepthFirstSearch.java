package org.example.DepthFirstSearch;

import org.example.model.Vertex;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {

        // it may happen that we have independent clusters
        for(Vertex vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex rootVertex) {
        // LIFO structure
        stack.add(rootVertex);
        rootVertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println(actualVertex);

            // consider all the neighbors
            for (Vertex v : actualVertex.getAdjacencyList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }

    }
}
