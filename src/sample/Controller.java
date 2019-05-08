package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    @FXML
    private Button myButton;

    @FXML
    private MenuItem newFileMenuItem;

    @FXML
    private MenuItem openFileMenuItem;

    @FXML
    private MenuItem saveMenuItem;

    @FXML
    private HTMLEditor textEditor;




    @Override
    public void initialize (URL location, ResourceBundle resources){}


    public void createFile(ActionEvent actionEvent) {
        System.out.println("kfkfkfkf");

    }
    public void openFile(ActionEvent actionEvent) {
        System.out.println("File { } opened");
    }

    public void saveFile(ActionEvent actionEvent) {
        System.out.println(System.getProperty("os.name"));
//        FileOutputStream fos = new FileOutputStream("")




    }
}





//{Label secondLabel = new Label("I'm a Label on new Window");
//    StackPane secondaryLayout = new StackPane();
//        secondaryLayout.getChildren().add(secondLabel);
//                Scene secondScene = new Scene(secondaryLayout, 230, 100);
//
//                // New window (Stage)
//                Stage newWindow = new Stage();
//                newWindow.setTitle("Second Stage");
//                newWindow.setScene(secondScene);
//
//                // Set position of second window, related to primary window.
//
//                newWindow.show();}
