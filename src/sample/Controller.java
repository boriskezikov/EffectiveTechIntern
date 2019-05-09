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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;



public class Controller implements Initializable {

    private final FileChooser fileChooser = new FileChooser();

    /** @value openedPath is a variable stores current work directory.(Opened file)*/
    private  Path openedPath;

    @FXML
    private TextArea textEditor= new TextArea();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /** Function which creates a new file */
    public void createFile() {

        /** @param alert Requests user confirmation to save file or not.*/
        Alert alert = new Alert(AlertType.CONFIRMATION);

        alert.setTitle("Confirm action");
        alert.setHeaderText("Do you want to save this document before closing?");
        alert.setContentText(null);
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                saveFile();}
            openedPath = new File("new.txt").toPath();
            setTitle();
        });

    }

    public void openFile() {
        try {
            /** @param file  - Open dialog to choose any file*/
            File file = fileChooser.showOpenDialog(Main.getPrimaryStage());
            if (file != null) {
                openedPath = file.toPath();
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String line = s.nextLine();
                    textEditor.appendText(line + "\n");
                }
                System.out.println("\nFile opened: " + file.getAbsolutePath());
            }
            setTitle();
        } catch (IOException ex) {
            System.out.println("Uuups! Something goes wrong in 'openFile'! " + ex.getMessage());
        }
    }

    public void saveFile() {
        try {
            if (openedPath != null) {
                Files.write(openedPath, textEditor.getText().getBytes());
                System.out.println("File saved");
            } else {
                saveAsFile();
            }
            setTitle();

        } catch (IOException ex) {
            System.out.println("Uuups! Something goes wrong while saving file! " + ex.getMessage());
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
                setTitle();
                return;
            }
            System.out.println("\nFile save procedure has been aborted. SAVE AS");
        } catch (IOException ex) {
            System.out.println("Uuups! Something goes wrong saving AS! " + ex.getMessage());
        }
    }

    public void openLink() {
        textEditor.setText("╔══╗╔══╦══╦╗╔╦╗╔╗\n"
                               + "╚═╗║║╔═╣╔╗║║║║║║║\n"
                               + "──║╚╝║─║║║║╚╝║╚╝║\n"
                               + "──║╔╗║─║║║╠═╗╠═╗║\n"
                               + "╔═╝║║╚═╣╚╝║─║║╔╝║\n"
                               + "╚══╝╚══╩══╝─╚╝╚═╝\n"
                               + "────╔═╗\n"
                               + "╔═══╬╗║\n"
                               + "╚═══╝║║\n"
                               + "╔═══╗║║\n"
                               + "╚═══╬╝║\n"
                               + "────╚═╝");

    }

    /** @exception java.lang.NullPointerException  */
    private void setTitle(){
        if (openedPath!=null){
            Main.getPrimaryStage().setTitle(openedPath.getFileName().toString());
        }
        else{
            Main.getPrimaryStage().setTitle("New file");
        }
    }


}

