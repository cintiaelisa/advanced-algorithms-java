package org.example.topologicalOrdering;

import org.example.model.Vertex;

import java.util.Stack;

public class TopologicalOrdering {

    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex) {

        vertex.setVisited(true);

        // all the neighbors in a DFS manner
        for (Vertex v : vertex.getNeighbors()) {
            if (!v.isVisited()) {
                dfs(v);
            }
        }

        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }

}
