package model;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordAlgorithm {

    public Map<Integer, Double> calculatePaths(Graph graph, int source) {
        Map<Integer, Double> distances = new HashMap<>();

        // Khởi tạo khoảng cách ban đầu cho tất cả các router
        for (Integer routerId : graph.getRouters()) {
            distances.put(routerId, Double.MAX_VALUE);
        }
        distances.put(source, 0.0);  // Khoảng cách từ router nguồn về chính nó là 0

        int numRouters = graph.getRouters().size();
        // Chạy thuật toán Bellman-Ford
        for (int i = 0; i < numRouters - 1; i++) {
            for (Link link : graph.getLinksFromRouter(source)) {
                int start = link.getFrom();  // Lấy router bắt đầu từ link
                int end = link.getTo();      // Lấy router kết thúc từ link
                double weight = link.getWeight();   // Lấy trọng số của liên kết

                // Nếu tìm thấy đường đi ngắn hơn, cập nhật khoảng cách
                if (distances.get(start) + weight < distances.get(end)) {
                    distances.put(end, distances.get(start) + weight);
                }
            }
        }

        return distances;
    }
}
