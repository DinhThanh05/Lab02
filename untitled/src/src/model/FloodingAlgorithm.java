package model;

import java.util.HashSet;
import java.util.Set;

public class FloodingAlgorithm {
    public void flood(Graph graph, Router source) {
        Set<Router> visited = new HashSet<>();
        floodRecursive(source, visited);
    }

    private void floodRecursive(Router current, Set<Router> visited) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);
        System.out.println("Flooding to router: " + current.getName());
        for (Link link : current.getLinks()) {
            floodRecursive(link.getEndRouter(), visited);
        }
    }
}
