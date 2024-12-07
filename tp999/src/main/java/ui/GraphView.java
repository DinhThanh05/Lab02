package ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Graph;
import model.Link;

import java.util.List;
import java.util.Map;

public class GraphView extends Canvas {
    private Graph graph;

    public GraphView(Graph graph) {
        this.graph = graph;
        this.setWidth(800);  // Kích thước của Canvas
        this.setHeight(600);
    }

    public void drawGraph() {
        GraphicsContext gc = this.getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());  // Xóa mọi thứ trước khi vẽ lại

        Map<Integer, List<Link>> adjacencyList = graph.getAdjacencyList();
        for (Integer nodeId : adjacencyList.keySet()) {
            List<Link> links = adjacencyList.get(nodeId);

            // Vẽ node (mỗi node là một điểm)
            gc.setFill(Color.BLUE);  // Màu sắc của node
            gc.fillOval(nodeId * 50, 100, 20, 20);  // Dùng nodeId làm tọa độ ví dụ

            // Vẽ các edges (liên kết) của node
            for (Link link : links) {
                Integer toNodeId = link.getTo();
                // Vẽ đường nối từ nodeId đến toNodeId
                gc.setStroke(Color.BLACK);
                gc.strokeLine(nodeId * 50 + 10, 110, toNodeId * 50 + 10, 110);  // Vẽ đường thẳng giữa các node
            }
        }
    }
}
