package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * Fx Notepad application.
 *
 * @version SNAPSHOT
 */

public class Main extends Application {

    private static Stage primaryStage;

    private Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception {

        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Text editor");
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);

        scene.setOnKeyPressed(event -> {

                                  /** @value kb - Key combination adds feature to save file using CTRL+S shortcut*/
                                  final KeyCombination kb = new KeyCodeCombination(KeyCode.S,
                                                                                   KeyCombination.CONTROL_ANY);

                                  if (kb.match(event)) {
                                      controller.saveFile();
                                  }
                              }
        );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static Stage getPrimaryStage() {
        return Main.primaryStage;
    }
}
