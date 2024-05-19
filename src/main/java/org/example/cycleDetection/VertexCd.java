package org.example.cycleDetection;

import java.util.ArrayList;
import java.util.List;

public class VertexCd {

    private String name;
    private boolean visited;
    private boolean beingVisited;
    private List<VertexCd> adjacenciesList;

    public VertexCd(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beinhVisited) {
        beingVisited = beinhVisited;
    }

    public List<VertexCd> getNeighbors() {
        return adjacenciesList;
    }

    public void addNeighbor(VertexCd vertex) {
        this.adjacenciesList.add(vertex);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
