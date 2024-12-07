package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HelpMenu extends VBox {
    public HelpMenu() {
        // Giải thích về thuật toán Dijkstra
        Button dijkstraButton = new Button("Giải thích Dijkstra");
        dijkstraButton.setOnAction(e -> System.out.println("Dijkstra là thuật toán tìm đường đi ngắn nhất..."));

        // Giải thích về thuật toán Bellman-Ford
        Button bellmanFordButton = new Button("Giải thích Bellman-Ford");
        bellmanFordButton.setOnAction(e -> System.out.println("Bellman-Ford tính toán đường đi ngắn nhất..."));

        // Giải thích về thuật toán Flooding
        Button floodingButton = new Button("Giải thích Flooding");
        floodingButton.setOnAction(e -> System.out.println("Flooding là phương pháp phát tán tin nhắn..."));

        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.getChildren().addAll(dijkstraButton, bellmanFordButton, floodingButton);
    }
}
