package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;  // Thêm import này để sử dụng TextField
import javafx.stage.Stage;
import model.DijkstraAlgorithm;
import model.Graph;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.Map;

public class MainMenu extends BorderPane {
    private Graph graph;
    private ComboBox<String> algorithmSelector;
    private TextArea outputArea;

    public MainMenu(Graph graph) {
        this.graph = graph;

        // Top Panel for menu buttons
        FlowPane topPanel = new FlowPane();
        Button addNodeButton = new Button("Add Node");
        Button runAlgorithmButton = new Button("Run Algorithm");
        Button helpButton = new Button("Help");
        Button quitButton = new Button("Quit");

        // Add buttons to top panel
        topPanel.getChildren().addAll(addNodeButton, runAlgorithmButton, helpButton, quitButton);

        // Center Panel for output
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Bottom Panel for algorithm selection
        VBox bottomPanel = new VBox();
        algorithmSelector = new ComboBox<>();
        algorithmSelector.getItems().addAll("Dijkstra", "Bellman-Ford", "Floyd-Warshall");
        bottomPanel.getChildren().addAll(new Label("Select Algorithm:"), algorithmSelector);

        // Add panels to BorderPane layout
        this.setTop(topPanel);
        this.setCenter(outputArea);
        this.setBottom(bottomPanel);

        // Button Listeners
        addNodeButton.setOnAction(e -> addNodeDialog());
        runAlgorithmButton.setOnAction(e -> runAlgorithm());
        helpButton.setOnAction(e -> showHelp());
        quitButton.setOnAction(e -> System.exit(0));
    }

    // Add Node Dialog
    private void addNodeDialog() {
        TextField fromField = new TextField();  // Sử dụng TextField của JavaFX
        TextField toField = new TextField();    // Sử dụng TextField của JavaFX
        TextField weightField = new TextField();  // Sử dụng TextField của JavaFX

        FlowPane panel = new FlowPane();
        panel.getChildren().addAll(new Label("From:"), fromField, new Label("To:"), toField, new Label("Weight:"), weightField);

        // Hiển thị hộp thoại
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle("Add Edge");
        alert.getDialogPane().setContent(panel);

        alert.showAndWait().ifPresent(response -> {
            if (response == javafx.scene.control.ButtonType.OK) {
                try {
                    int from = Integer.parseInt(fromField.getText());
                    int to = Integer.parseInt(toField.getText());
                    int weight = Integer.parseInt(weightField.getText());
                    graph.addLink(from, to, weight);
                    outputArea.appendText("Added edge: " + from + " -> " + to + " with weight " + weight + "\n");
                } catch (NumberFormatException ex) {
                    outputArea.appendText("Invalid input! Please enter integers.\n");
                }
            }
        });
    }


    private void runAlgorithm() {
        String algorithm = algorithmSelector.getValue();
        outputArea.appendText("Running algorithm: " + algorithm + "\n");

        // Tạo đối tượng SimulationScreen và GraphView
        GraphView graphView = new GraphView(graph);
        SimulationScreen simulationScreen = new SimulationScreen(graph);

        switch (algorithm) {
            case "Dijkstra":
                // Chạy thuật toán Dijkstra
                int sourceRouterDijkstra = 1;  // Chọn một router nguồn, ví dụ: 1
                DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
                Map<Integer, Double> dijkstraResult = dijkstra.calculatePaths(graph, sourceRouterDijkstra);

                outputArea.appendText("Shortest paths from router " + sourceRouterDijkstra + ":\n");
                for (Map.Entry<Integer, Double> entry : dijkstraResult.entrySet()) {
                    outputArea.appendText("Router " + entry.getKey() + ": " + entry.getValue() + "\n");
                }

                // Sau khi chạy thuật toán Dijkstra, mô phỏng và hiển thị đồ thị
                simulationScreen.updateSimulation(dijkstraResult);

//                // Tạo một cửa sổ mới để hiển thị đồ thị và mô phỏng
//                Stage simulationStage = new Stage();
//                VBox simulationLayout = new VBox();
//                simulationLayout.getChildren().add(simulationScreen);  // Thêm SimulationScreen vào layout
//
//                // Tạo scene cho cửa sổ mô phỏng
//                Scene simulationScene = new Scene(simulationLayout, 800, 600);
//                simulationStage.setTitle("Simulation - Shortest Path");
//                simulationStage.setScene(simulationScene);
//                simulationStage.show();

                Stage stage = new Stage();
                VBox layout = new VBox();
                graphView.drawGraph();
                layout.getChildren().add(graphView);
                Scene scene = new Scene(layout, 800, 600);

                stage.setTitle("Simulation - Shortest Path");
                stage.setScene(scene);
                stage.show();
                break;
            case "Bellman-Ford":
                outputArea.appendText("Bellman-Ford algorithm not implemented yet.\n");
                break;
            case "Floyd-Warshall":
                outputArea.appendText("Floyd-Warshall algorithm not implemented yet.\n");
                break;
            default:
                outputArea.appendText("Unknown algorithm.\n");
        }
    }


    // Show Help Dialog
    // Show Help Dialog
    private void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("""
            Help Guide:
            - Add Node: Add edges with nodes and weights.
            - Select Algorithm: Choose one of the shortest path algorithms.
            - Run Algorithm: Execute the selected algorithm.
            - Quit: Exit the application.""");
        alert.showAndWait();
    }

}
