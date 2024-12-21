import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        // Cài đặt bố cục cho Frame
        setLayout(new GridLayout(2, 2));

        // Nhãn đầu vào
        add(new Label("Enter a number: "));

        // TextField để nhập
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new InputListener());

        // Nhãn kết quả
        add(new Label("Accumulated sum: "));

        // TextField để hiển thị tổng
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Chỉ đọc
        add(tfOutput);

        // Cài đặt thuộc tính Frame
        setTitle("AWT Accumulator");
        setSize(350, 120);
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
        new AWTAccumulator();
    }
}
