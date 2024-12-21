package hust.soict.globalict.painter;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    // Xử lý sự kiện kéo chuột để vẽ
    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

    // Xử lý sự kiện nút "Clear"
    @FXML
    private void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
