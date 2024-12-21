package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreenFX extends JFrame {
    private Cart cart;

    public CartScreenFX(Cart cart) {
        this.cart = cart;

        // Cài đặt JFrame
        setTitle("Cart Screen with JavaFX");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tích hợp JFXPanel
        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        // Khởi tạo JavaFX
        Platform.runLater(() -> initFX(fxPanel));

        setVisible(true);
    }

    private void initFX(JFXPanel fxPanel) {
        try {
            // Tải tệp FXML và gắn controller
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            loader.setController(new CartScreenController(cart));

            // Tạo Scene từ FXML
            Scene scene = new Scene(loader.load());
            fxPanel.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Tạo giỏ hàng mẫu
        Cart cart = new Cart();
        cart.addMedia(new hust.soict.globalict.aims.media.Media("Book 1", "Books", 19.95));
        cart.addMedia(new hust.soict.globalict.aims.media.Media("DVD 1", "DVDs", 14.95));
        cart.addMedia(new hust.soict.globalict.aims.media.Media("CD 1", "CDs", 9.95));

        SwingUtilities.invokeLater(() -> new CartScreenFX(cart));
    }
}
