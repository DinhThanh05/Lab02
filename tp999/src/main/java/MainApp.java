import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.MainMenu;
import model.Graph;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Graph graph = new Graph(); // Khởi tạo graph
        MainMenu mainMenu = new MainMenu(graph); // Khởi tạo MainMenu với graph

        Scene scene = new Scene(mainMenu, 800, 600); // Tạo scene với MainMenu
        primaryStage.setTitle("Routing Simulation"); // Tiêu đề cửa sổ
        primaryStage.setScene(scene); // Gán scene cho stage
        primaryStage.show(); // Hiển thị stage
    }

    public static void main(String[] args) {
        launch(args); // Khởi chạy ứng dụng JavaFX
    }
}
