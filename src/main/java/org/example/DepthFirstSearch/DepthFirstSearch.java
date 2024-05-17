package org.example.DepthFirstSearch;

import org.example.model.Vertex;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack;

    public DepthFirstSearch() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vertexList) {

        // it may happen that we have independent clusters
        for (Vertex vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    private void dfsHelper(Vertex rootVertex) {
        // LIFO structure
        rootVertex.setVisited(true);
        stack.add(rootVertex);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println(actualVertex);

            // consider all the neighbors
            // reverse to preserve the same traversing order as in recursive
            // implementation, from left to right
            Collections.reverse(actualVertex.getNeighbors());
            for (Vertex v : actualVertex.getNeighbors()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }

    }
}
