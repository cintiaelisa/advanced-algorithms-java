package org.example.topologicalOrderingShortestPath;

import java.util.ArrayList;
import java.util.List;

public class VertexSp {

    private String name;
    private boolean visited;
    // shortest path from the source vertex to actual vertex
    private int minDistance;
    // the previous node in the shortest path
    private VertexSp predecessor;
    private List<Edge> adjacencyList;

    public VertexSp(String name) {
        this.name = name;
        minDistance = Integer.MAX_VALUE;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public VertexSp getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(VertexSp predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getNeighbors() {
        return adjacencyList;
    }

    public void addNeighbor(Edge edge) {
        this.adjacencyList.add(edge);
    }

    @Override
    public String toString() {
        return this.name + " - " + predecessor;
    }
}
