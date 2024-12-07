package model;

import java.util.*;

public class DijkstraAlgorithm {
    public Map<Router, Double> calculatePaths(Graph graph, Router source) {
        Map<Router, Double> distances = new HashMap<>();
        Map<Router, Router> previous = new HashMap<>();

        for (Router router : graph.getRouters()) {
            distances.put(router, Double.MAX_VALUE);
            previous.put(router, null);
        }
        distances.put(source, 0.0);

        PriorityQueue<Router> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(source);

        while (!queue.isEmpty()) {
            Router current = queue.poll();
            for (Link link : current.getLinks()) {
                Router neighbor = link.getEndRouter();
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
