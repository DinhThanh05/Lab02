package model;

import java.util.*;

public class DijkstraAlgorithm {

    public Map<Integer, Double> calculatePaths(Graph graph, int source) {
        Map<Integer, Double> distances = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();

        // Lấy tất cả các routers từ graph
        for (Integer router : graph.getRouters()) {
            distances.put(router, Double.MAX_VALUE);
            previous.put(router, null);
        }
        distances.put(source, 0.0);

        // Priority queue để lưu các routers với khoảng cách nhỏ nhất
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(source);

        // Dijkstra algorithm
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Link link : graph.getAdjacencyList().get(current)) {
                Integer neighbor = link.getTo(); // Để lấy node đích của liên kết
                double newDist = distances.get(current) + link.getWeight();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }
}
