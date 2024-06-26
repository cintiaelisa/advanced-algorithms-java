package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbors() {
        return adjacencyList;
    }

    public void addNeighbor(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
