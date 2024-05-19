package org.example.dijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void computePath(Vertex source) {
        source.setDistance(0);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.poll();

            for (Edge edge : actualVertex.getAdjacencyList()) {
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();

                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance()) {
                    // There is a shorter path to vertex v
                    // IS IT WORKING FINE?
                    // O(N) and of course O(logN) would be better
                    queue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    queue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor())
            path.add(vertex);

        Collections.reverse(path);

        return path;
    }
}
