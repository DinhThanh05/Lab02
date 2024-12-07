module tp9 {
    requires javafx.controls;  // Cần khai báo module javafx.controls nếu sử dụng JavaFX
    requires javafx.fxml;     // Nếu bạn sử dụng FXML
    requires java.base;       // Java base module mặc định
 //   requires java.graphics;
    
    exports app;  // Export package chứa lớp MainApp hoặc các lớp cần sử dụng
    exports model;  // Export các lớp mô hình (Router, Link, Simulator)
    exports ui;     // Export các lớp giao diện người dùng
}
