package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.media.Media;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Tiêu đề sản phẩm
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Thể loại sản phẩm
        JLabel category = new JLabel("Category: " + media.getCategory());
        category.setAlignmentX(CENTER_ALIGNMENT);

        // Giá sản phẩm
        JLabel cost = new JLabel("Cost: $" + media.getCost());
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Nút "Play" (nếu Media có thể phát)
        JButton btnPlay = new JButton("Play");
        btnPlay.setAlignmentX(CENTER_ALIGNMENT);
        btnPlay.setEnabled(media.isPlayable()); // Chỉ khả dụng nếu sản phẩm có thể phát

        // Nút "Add to Cart"
        JButton btnAddToCart = new JButton("Add to Cart");
        btnAddToCart.setAlignmentX(CENTER_ALIGNMENT);

        // Thêm các thành phần vào panel
        add(Box.createVerticalStrut(10)); // Khoảng cách
        add(title);
        add(Box.createVerticalStrut(5));
        add(category);
        add(Box.createVerticalStrut(5));
        add(cost);
        add(Box.createVerticalStrut(10));
        add(btnPlay);
        add(Box.createVerticalStrut(5));
        add(btnAddToCart);
    }
}
