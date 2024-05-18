package org.example.topologicalOrdering;

import org.example.model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

    public static void main(String[] args) {

        TopologicalOrdering ordering = new TopologicalOrdering();

        List<Vertex> grapqh = new ArrayList<>();

        grapqh.add(new Vertex("0"));
        grapqh.add(new Vertex("1"));
        grapqh.add(new Vertex("2"));
        grapqh.add(new Vertex("3"));
        grapqh.add(new Vertex("4"));
        grapqh.add(new Vertex("5"));

        grapqh.get(2).addNeighbor(grapqh.get(3));

        grapqh.get(3).addNeighbor(grapqh.get(1));

        grapqh.get(4).addNeighbor(grapqh.get(0));
        grapqh.get(4).addNeighbor(grapqh.get(1));

        grapqh.get(5).addNeighbor(grapqh.get(0));
        grapqh.get(5).addNeighbor(grapqh.get(2));

        // consider all the vertices
        for (Vertex vertex : grapqh) {
            if (!vertex.isVisited()) {
                ordering.dfs(vertex);
            }
        }

        Stack<Vertex> stack = ordering.getStack();

        for (int i = 0; i < grapqh.size(); i++) {
            System.out.println(stack.pop());
        }
    }
}
