package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class Controller implements Initializable {

    private final FileChooser fileChooser = new FileChooser();

    @FXML
    private TextArea textEditor;

    @FXML
    private TextField console;

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
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String line = s.nextLine();
                    textEditor.appendText(line + "\n");
                }
                console.setText("\nFile opened: " + file.getAbsolutePath());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void saveFile() throws IOException {
         File file = fileChooser.showSaveDialog(Main.getPrimaryStage());
        if (file != null){
            if (!file.getName().contains(".")){
                file = new File(file.getName() + ".txt");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(textEditor.getText());
            console.setText("\nFile saved: " + file.getAbsolutePath());
            return;
        }
        console.setText("\nFile save procedure has been aborted.");

    }

    @Deprecated
    public void consoleLog(){

    }

    private boolean testIdentity(File freshFile, File oldFile){
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

