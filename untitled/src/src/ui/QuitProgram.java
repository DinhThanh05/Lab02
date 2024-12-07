package ui;

import javafx.scene.control.Button;

public class QuitProgram {
    public static Button createQuitButton() {
        Button quitButton = new Button("Thoát");
        quitButton.setOnAction(e -> System.exit(0));  // Đóng ứng dụng khi nhấn nút
        return quitButton;
    }
}
