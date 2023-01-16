import javafx.scene.control.CheckBox;
import org.xml.sax.SAXException;
import parser.*;
import ReadingAndWriting.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        CheckBox encrypted = new CheckBox("encrypted");

        Label lbl = new Label("Input file name");
        Label lbl2 = new Label("Output file name");
        TextField textField = new TextField();
        textField.setPrefColumnCount(11);
        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(11);
        Button btn = new Button("Click");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            TypeOfFile faj = new TypeOfFile();
                try {
                    boolean mode = false;
                    if(encrypted.isSelected()){
                    mode = true;
                    }
                    faj.Start(textField.getText(), textField1.getText(),mode);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParserException e) {
                    throw new RuntimeException(e);
                } catch (ParserConfigurationException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchPaddingException e) {
                    throw new RuntimeException(e);
                } catch (IllegalBlockSizeException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                } catch (BadPaddingException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeyException e) {
                    throw new RuntimeException(e);
                } catch (TransformerException e) {
                    throw new RuntimeException(e);
                } catch (SAXException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,lbl, textField, encrypted,lbl2, textField1, btn);
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("TextField in JavaFX");
        stage.show();
    }
}
