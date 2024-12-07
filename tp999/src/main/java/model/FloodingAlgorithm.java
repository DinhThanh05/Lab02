package model;

import java.util.HashSet;
import java.util.Set;

public class FloodingAlgorithm {
    public void flood(Graph graph, int source) {
        Set<Integer> visited = new HashSet<>();
        floodRecursive(graph, source, visited);
    }

    private void floodRecursive(Graph graph, int current, Set<Integer> visited) {
        if (visited.contains(current)) {
            return;
        }
        visited.add(current);
        System.out.println("Flooding to router: " + current);

        // Lấy danh sách các liên kết từ router hiện tại
        for (Link link : graph.getLinksFromRouter(current)) {
            int neighbor = (link.getFrom() == current) ? link.getTo() : link.getFrom();
            floodRecursive(graph, neighbor, visited);
        }
    }
}
