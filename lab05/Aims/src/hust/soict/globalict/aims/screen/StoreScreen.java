package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Media;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StoreScreen extends JFrame {
    private Store store;

    public StoreScreen(Store store) {
        this.store = store;

        // Cài đặt giao diện chính
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Tạo các thành phần giao diện
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Cài đặt JFrame
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Tạo khu vực NORTH (menu và tiêu đề)
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View Cart"));
        menu.add(new JMenuItem("Exit"));
        menuBar.add(menu);

        // Header
        JLabel header = new JLabel("Store", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 50));

        north.add(menuBar, BorderLayout.NORTH);
        north.add(header, BorderLayout.CENTER);

        return north;
    }

    // Tạo khu vực CENTER (danh sách sản phẩm)
    private JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 10, 10)); // Bố cục lưới 3x3, khoảng cách 10px

        // Lấy danh sách sản phẩm từ Store
        List<Media> mediaList = store.getItemsInStore();

        for (Media media : mediaList) {
            center.add(new MediaStore(media)); // Tạo giao diện cho từng sản phẩm
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Thêm sản phẩm mẫu
        store.addMedia(new Media("Book 1", "Books", 19.95));
        store.addMedia(new Media("DVD 1", "DVDs", 14.95));
        store.addMedia(new Media("CD 1", "CDs", 9.95));

        new StoreScreen(store);
    }
}
