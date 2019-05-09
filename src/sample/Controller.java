package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;


public class Controller implements Initializable {

    private final FileChooser fileChooser = new FileChooser();

    private static Path openedPath;

    @FXML
    private TextArea textEditor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFile() {
        System.out.println("\nFile created: ");
    }

    public void openFile() {
        textEditor.clear();
        try {
            File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
            if (file != null) {
                openedPath = file.toPath();
                System.out.println(openedPath);
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String line = s.nextLine();
                    textEditor.appendText(line + "\n");
                }
                System.out.println("\nFile opened: " + file.getAbsolutePath());
            }

        } catch (IOException ex) {
            System.out.println("Uuups! Something goes wrong! " + ex.getMessage());
        }
    }

    public void saveFile() throws IOException {
        if (openedPath != null) {
            Files.write(openedPath, textEditor.getText().getBytes());
            System.out.println("File saved");
        }
        else{
            saveAsFile();
        }
    }

    public void saveAsFile() {
        try {
            File file = fileChooser.showSaveDialog(Main.getPrimaryStage());
            if (file != null) {
                if (!file.getName().contains(".") || file.getName().indexOf(".") != -1) {
                    file = new File(file.getName().replace(".", "") + ".txt");
                }
                openedPath = file.toPath();
                Files.write(openedPath, textEditor.getText().getBytes());
                System.out.println("\nFile saved at path: " + file.getAbsolutePath());
                return;
            }
            System.out.println("\nFile save procedure has been aborted.");

        } catch (IOException ex) {
            System.out.println("Uuups! Something goes wrong! " + ex.getMessage());
        }
    }

    static boolean testIdentity() {

        return true ;//openedPath.toFile().lastModified() == ;
    }

    public void testIdentity(KeyEvent event)
    {
        final KeyCombination kb = new KeyCodeCombination(KeyCode.TAB, KeyCombination.CONTROL_DOWN);

        if (kb.match(event))
        {
           saveAsFile();
        }
    }
    public void openLink() {
        textEditor.setText("╔══╗╔══╦══╦╗╔╦╗╔╗\n"
                               + "╚═╗║║╔═╣╔╗║║║║║║║\n"
                               + "──║╚╝║─║║║║╚╝║╚╝║\n"
                               + "──║╔╗║─║║║╠═╗╠═╗║\n"
                               + "╔═╝║║╚═╣╚╝║─║║╔╝║\n"
                               + "╚══╝╚══╩══╝─╚╝╚═╝\n"
                               + "╔═══╦══╦═══╦══╦════╦══╦════╦╗\n"
                               + "║╔═╗║╔╗║╔══╣╔╗╠═╗╔═╣╔╗╠═╗╔═╣║\n"
                               + "║╚═╝║╚╝║╚══╣║║║─║║─║╚╝║─║║─║╚══╗\n"
                               + "║╔══╣╔╗║╔═╗║║║║─║║─║╔╗║─║║─║╔═╗║\n"
                               + "║║──║║║║╚═╝║╚╝║─║║─║║║║─║║─║╚═╝║\n"
                               + "╚╝──╚╝╚╩═══╩══╝─╚╝─╚╝╚╝─╚╝─╚═══╝\n"
                               + "────╔═╗\n"
                               + "╔═══╬╗║\n"
                               + "╚═══╝║║\n"
                               + "╔═══╗║║\n"
                               + "╚═══╬╝║\n"
                               + "────╚═╝");

    }


}

