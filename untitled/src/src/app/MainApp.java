package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.MainMenu;
import model.Graph;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Graph graph = new Graph();
        MainMenu mainMenu = new MainMenu(graph);
        Scene scene = new Scene(mainMenu, 800, 600);

        primaryStage.setTitle("Routing Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
