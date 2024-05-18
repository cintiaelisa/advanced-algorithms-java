package org.example.topologicalOrderingShortestPath;

public class Edge {

    private VertexSp target;
    private int weight;

    public Edge(VertexSp target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public VertexSp getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }
}
