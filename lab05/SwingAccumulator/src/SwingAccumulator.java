import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        // Cài đặt bố cục
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));

        // Nhãn đầu vào
        contentPane.add(new JLabel("Enter a number: "));

        // TextField để nhập
        tfInput = new JTextField(10);
        contentPane.add(tfInput);
        tfInput.addActionListener(new InputListener());

        // Nhãn kết quả
        contentPane.add(new JLabel("Accumulated sum: "));

        // TextField để hiển thị tổng
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Chỉ đọc
        contentPane.add(tfOutput);

        // Cài đặt thuộc tính JFrame
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Inner class để xử lý sự kiện nhập
    private class InputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int number = Integer.parseInt(tfInput.getText());
            sum += number;
            tfInput.setText("");
            tfOutput.setText(Integer.toString(sum));
        }
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }
}
