import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TextClass extends JFrame {
    private JTextField textField;

    public TextClass() {
        super("Dialog frame");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Enter");
        panel.add(button1);
        JTextArea textArea = new JTextArea("Enter the type of opening file ");
        panel.add(textArea);
        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status;
                status = textField.getText();
                System.out.print(status);
                dispose();
            }
        });

        getContentPane().add(panel);
        setPreferredSize(new Dimension(320, 100));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TextClass frame = new TextClass();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
