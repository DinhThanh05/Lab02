package ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import model.Graph;
import model.Link;

import java.util.List;
import java.util.Map;

public class SimulationScreen extends javafx.scene.layout.Pane {
    private Graph graph;
    private Map<Integer, Double> algorithmResult;  // Kết quả thuật toán (khoảng cách từ nguồn đến các router)

    public SimulationScreen(Graph graph) {
        this.graph = graph;
        this.setPrefSize(800, 600);  // Kích thước mặc định
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        drawGraph();
    }

    private void drawGraph() {
        Map<Integer, List<Link>> adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Integer, List<Link>> entry : adjacencyList.entrySet()) {
            int router = entry.getKey();
            List<Link> links = entry.getValue();
            for (Link link : links) {
                int from = link.getFrom();
                int to = link.getTo();

//                System.out.println(from + " " + to);
                drawLink(from, to);
            }
        }
    }

    private void drawLink(int from, int to) {
        // Vẽ đường nối giữa các router
        Line line = new Line(from * 50, from * 50, to * 50, to * 50);
        line.setStroke(Color.BLACK);  // Mặc định vẽ các đường nối màu đen
        getChildren().add(line);  // Thêm line vào layout
    }

    public void updateSimulation(Map<Integer, Double> algorithmResult) {
        this.algorithmResult = algorithmResult;  // Lưu kết quả thuật toán
        // Vẽ lại các liên kết với màu sắc thay đổi tùy theo kết quả thuật toán
        getChildren().clear();  // Xóa các node cũ trong Pane

        Map<Integer, List<Link>> adjacencyList = graph.getAdjacencyList();
        for (Map.Entry<Integer, List<Link>> entry : adjacencyList.entrySet()) {
            int router = entry.getKey();
            List<Link> links = entry.getValue();
            for (Link link : links) {
                int from = link.getFrom();
                int to = link.getTo();

                // Lấy khoảng cách từ kết quả thuật toán
                Double fromDistance = algorithmResult.get(from);
                Double toDistance = algorithmResult.get(to);

                // Nếu khoảng cách từ nguồn đến đích có giá trị nhỏ nhất, vẽ đường với màu khác
                if (fromDistance != null && toDistance != null) {
                    if (fromDistance < toDistance) {
                        drawLinkWithColor(from, to, Color.GREEN);  // Màu xanh nếu từ router "from" đến "to" là đường đi ngắn nhất
                    } else {
                        drawLinkWithColor(from, to, Color.RED);  // Màu đỏ nếu không phải đường đi ngắn nhất
                    }
                }
            }
        }
    }

    private void drawLinkWithColor(int from, int to, Color color) {
        // Vẽ node
//        Circle nodeFrom = new Circle(from * 50, 100, 20);
//        Circle nodeTo = new Circle(to * 50, 100, 20);
//
//        getChildren().add(nodeFrom);
//        getChildren().add(nodeTo);

        // Vẽ đường nối giữa các router với màu sắc được chỉ định
        Line line = new Line(from * 50, from * 50, to * 50, to * 50);
        line.setStroke(color);  // Đặt màu cho đường nối
        getChildren().add(line);  // Thêm line vào layout
    }
}
