package model;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordAlgorithm {
    public Map<Router, Double> calculatePaths(Graph graph, Router source) {
        Map<Router, Double> distances = new HashMap<>();
        for (Router router : graph.getRouters()) {
            distances.put(router, Double.MAX_VALUE);
        }
        distances.put(source, 0.0);

        int numRouters = graph.getRouters().size();
        for (int i = 0; i < numRouters - 1; i++) {
            for (Link link : graph.getLinks()) {
                Router start = link.getStartRouter();
                Router end = link.getEndRouter();
                double weight = link.getWeight();
                if (distances.get(start) + weight < distances.get(end)) {
                    distances.put(end, distances.get(start) + weight);
                }
            }
        }

        return distances;
    }
}
