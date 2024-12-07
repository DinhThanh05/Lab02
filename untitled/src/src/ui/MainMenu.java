package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.*;

public class MainMenu extends VBox {
    public MainMenu(Graph graph) {
        // TextField nhập thông tin Router và Link
        TextField routerNameInput = new TextField();
        routerNameInput.setPromptText("Nhập tên Router");

        TextField routerXInput = new TextField();
        routerXInput.setPromptText("Nhập tọa độ X");

        TextField routerYInput = new TextField();
        routerYInput.setPromptText("Nhập tọa độ Y");

        TextField linkWeightInput = new TextField();
        linkWeightInput.setPromptText("Nhập trọng số Link");

        Button addRouterButton = new Button("Thêm Router");
        addRouterButton.setOnAction(e -> {
            String routerName = routerNameInput.getText();
            double x = Double.parseDouble(routerXInput.getText());
            double y = Double.parseDouble(routerYInput.getText());
            Router newRouter = new Router(routerName, x, y);
            graph.addRouter(newRouter);

            routerNameInput.clear();
            routerXInput.clear();
            routerYInput.clear();
        });

        Button addLinkButton = new Button("Thêm Link");
        addLinkButton.setOnAction(e -> {
            String router1Name = routerNameInput.getText();
            String router2Name = routerXInput.getText();  // Dùng X làm tên Router2 cho demo
            double weight = Double.parseDouble(linkWeightInput.getText());

            Router router1 = null;
            Router router2 = null;
            for (Router router : graph.getRouters()) {
                if (router.getName().equals(router1Name)) {
                    router1 = router;
                }
                if (router.getName().equals(router2Name)) {
                    router2 = router;
                }
            }

            if (router1 != null && router2 != null) {
                Link newLink = new Link(router1, router2, weight);
                graph.addLink(newLink);
                router1.addLink(newLink);
                router2.addLink(newLink);
            }

            linkWeightInput.clear();
        });

        // ComboBox để chọn thuật toán
        ComboBox<String> algorithmSelector = new ComboBox<>();
        algorithmSelector.getItems().addAll("Dijkstra", "Bellman-Ford", "Flooding");
        algorithmSelector.setValue("Dijkstra");

        Button runButton = new Button("Chạy Thuật Toán");
        runButton.setOnAction(e -> {
            Router firstRouter = graph.getRouters().get(0);
            switch (algorithmSelector.getValue()) {
                case "Dijkstra":
                    new DijkstraAlgorithm().calculatePaths(graph, firstRouter);
                    break;
                case "Bellman-Ford":
                    new BellmanFordAlgorithm().calculatePaths(graph, firstRouter);
                    break;
                case "Flooding":
                    new FloodingAlgorithm().flood(graph, firstRouter);
                    break;
            }
        });

        Button quitButton = new Button("Thoát");
        quitButton.setOnAction(e -> System.exit(0));

        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.getChildren().addAll(routerNameInput, routerXInput, routerYInput, linkWeightInput, addRouterButton, addLinkButton, algorithmSelector, runButton, quitButton);
    }
}
