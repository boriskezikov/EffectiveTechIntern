package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Controller implements Initializable {

    private final FileChooser fileChooser = new FileChooser();

    private Path openedPath;

    @FXML
    private TextArea textEditor;

    @FXML
    private TextArea console;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFile() {
        console.setText("\nFile created: ");
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
                console.setText("\nFile opened: " + file.getAbsolutePath());
            }

        } catch (IOException ex) {
            console.setText("Uuups! Something goes wrong! " + ex.getMessage());
        }
    }

    public void saveFile() throws IOException {
        if (openedPath != null) {
            Files.write(openedPath, textEditor.getText().getBytes());
            console.setText("File saved");
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
                console.setText("\nFile saved at path: " + file.getAbsolutePath());
                return;
            }
            console.setText("\nFile save procedure has been aborted.");

        } catch (IOException ex) {
            console.setText("Uuups! Something goes wrong! " + ex.getMessage());
        }
    }

    private boolean testIdentity(File freshFile, File oldFile) {
        return freshFile.equals(oldFile);
    }

    public void openLink(ActionEvent actionEvent) {
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

