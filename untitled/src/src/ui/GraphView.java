package ui;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import model.Graph;
import model.Link;
import model.Router;

public class GraphView extends Pane {

    // Constructor nhận đối tượng Graph để vẽ
    public GraphView(Graph graph) {
        drawGraph(graph);  // Vẽ đồ thị khi GraphView được tạo
    }

    // Phương thức vẽ đồ thị
    private void drawGraph(Graph graph) {
        // Vẽ tất cả các Link
        for (Link link : graph.getLinks()) {
            Line line = new Line(
                link.getStartRouter().getX(), link.getStartRouter().getY(),
                link.getEndRouter().getX(), link.getEndRouter().getY()
            );
            line.setStroke(Color.GRAY); // Màu đường liên kết
            line.setStrokeWidth(2); // Độ dày đường
            this.getChildren().add(line); // Thêm vào Pane
        }

        // Vẽ các Router dưới dạng Circle
        for (Router router : graph.getRouters()) {
            Circle circle = new Circle(router.getX(), router.getY(), 15, Color.BLUE);  // Vị trí và màu sắc của router
            circle.setStroke(Color.BLACK);  // Màu viền của vòng tròn
            this.getChildren().add(circle);  // Thêm vào Pane
        }
    }
}
