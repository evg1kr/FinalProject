import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

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

        JButton button1 = new JButton("Enter input file");
        panel.add(button1);
        JButton button2 = new JButton("Enter output file");
        panel.add(button2);
        button2.setVisible(false);
        JTextArea textArea = new JTextArea("Enter the name of input file");
        panel.add(textArea);
        JTextArea textArea1 = new JTextArea("Enter the name of output file");
        panel.add(textArea1);
        textArea1.setVisible(false);
        textField = new JTextField();
        textField.setColumns(23);
        panel.add(textField);
        ReadingFromTxt a = new ReadingFromTxt();

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status;
                status = textField.getText();
                try {
                    a.Read(status);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                button2.setVisible(true);
                textArea1.setVisible(true);
                button1.setVisible(false);
                textArea.setVisible(false);
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String status;
                status = textField.getText();
                try {
                    a.Write(status);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    XMLreader a = new XMLreader();
                } catch (ParserConfigurationException ex) {
                    throw new RuntimeException(ex);
                } catch (TransformerException ex) {
                    throw new RuntimeException(ex);
                }
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
