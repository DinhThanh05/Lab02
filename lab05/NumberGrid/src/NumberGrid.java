import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JTextField tfDisplay;
    private JButton[] btnNumbers;
    private JButton btnDelete, btnReset;

    public NumberGrid() {
        // Cài đặt bố cục chính của JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // TextField hiển thị ở phía trên
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfDisplay, BorderLayout.NORTH);

        // JPanel chứa các nút số và nút chức năng
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3, 5, 5)); // 4 hàng x 3 cột, khoảng cách 5px

        // Tạo các nút số
        btnNumbers = new JButton[10];
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(new ButtonListener());
        }

        // Thêm nút "0"
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(new ButtonListener());

        // Thêm nút "DEL" và "C"
        btnDelete = new JButton("DEL");
        btnReset = new JButton("C");
        panelButtons.add(btnDelete);
        panelButtons.add(btnReset);

        btnDelete.addActionListener(new ButtonListener());
        btnReset.addActionListener(new ButtonListener());

        cp.add(panelButtons, BorderLayout.CENTER);

        // Cài đặt JFrame
        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Lớp xử lý sự kiện cho các nút
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String cmd = evt.getActionCommand();

            if ("DEL".equals(cmd)) {
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if ("C".equals(cmd)) {
                tfDisplay.setText("");
            } else {
                tfDisplay.setText(tfDisplay.getText() + cmd);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
