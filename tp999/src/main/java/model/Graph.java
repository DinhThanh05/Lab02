package model;

import java.util.*;

public class Graph {
    private Map<Integer, List<Link>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Thêm phương thức addLink nhận 3 tham số (from, to, weight)
    public void addLink(int from, int to, int weight) {
        Link link = new Link(from, to, weight);

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.get(from).add(link);

        adjacencyList.putIfAbsent(to, new ArrayList<>());
        adjacencyList.get(to).add(link);  // Bỏ dòng này nếu đồ thị có hướng
    }

    // Thêm phương thức để lấy danh sách các routers (node)
    public Set<Integer> getRouters() {
        return adjacencyList.keySet();
    }

    // Phương thức để lấy danh sách các liên kết
    public Map<Integer, List<Link>> getAdjacencyList() {
        return adjacencyList;
    }
    // Phương thức để lấy các liên kết của router từ
    public List<Link> getLinksFromRouter(int router) {
        return adjacencyList.getOrDefault(router, new ArrayList<>());
    }
}
