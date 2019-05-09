package sample;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Skin;
import javafx.scene.control.SkinBase;
import javafx.scene.control.Skinnable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;

public class Controller implements Initializable {

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

    @FXML
    private TextArea testText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFile(ActionEvent actionEvent) {
        System.out.println("kfkfkfkf");

    }

    public void openFile(ActionEvent actionEvent) {
        System.out.println("File { } opened");
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        System.out.println(textEditor.getSkin());
        String path = System.getProperty("user.dir");
        System.out.println(path);
        FileWriter fos = new FileWriter(
            new File(path, "name.txt"));
        fos.write(textEditor.getHtmlText());
        fos.close();
    }

    private static String getText(String htmlText) {

        String result = "";

        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(htmlText);
        final StringBuffer text = new StringBuffer(htmlText.length());

        while (matcher.find()) {
            matcher.appendReplacement(
                text,
                " ");
        }

        matcher.appendTail(text);

        result = text.toString().trim();

        return result;
    }
    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }

    private static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("nix") || os.contains("nux"));
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
