package org.example.topologicalOrderingShortestPath;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    private Stack<VertexSp> stack;

    public TopologicalOrdering(List<VertexSp> graph) {
        this.stack = new Stack<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i).isVisited()) {
                dfs(graph.get(i));
            }
        }
    }

    public void dfs(VertexSp vertex) {

        vertex.setVisited(true);

        // all the neighbors in a DFS manner
        for (Edge e : vertex.getNeighbors()) {
            if (!e.getTarget().isVisited()) {
                dfs(e.getTarget());
            }
        }

        stack.push(vertex);
    }

    public Stack<VertexSp> getStack() {
        return this.stack;
    }
}
