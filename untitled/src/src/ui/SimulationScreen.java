package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Graph;
import model.DijkstraAlgorithm;
import model.BellmanFordAlgorithm;
import model.FloodingAlgorithm;
import model.Router;

public class SimulationScreen extends VBox {

    public SimulationScreen(Graph graph) {
        // Vẽ đồ thị
        GraphView graphView = new GraphView(graph);

        Button runButton = new Button("Chạy Thuật Toán");
        runButton.setOnAction(e -> {
            Router firstRouter = graph.getRouters().get(0);
            new DijkstraAlgorithm().calculatePaths(graph, firstRouter);
        });

        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.getChildren().addAll(runButton, graphView);  // Thêm nút và đồ thị vào giao diện
    }
}
