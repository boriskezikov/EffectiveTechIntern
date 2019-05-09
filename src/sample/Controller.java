package sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Controller implements Initializable {

    @FXML
    private TextArea textEditor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void createFile(ActionEvent actionEvent) {
        System.out.println("kfkfkfkf");

    }

    public void openFile(ActionEvent actionEvent) throws IOException {
        final FileChooser fileChooser = new FileChooser();
        textEditor.clear();
        try
        {
            Scanner s = new Scanner(fileChooser.showOpenDialog(Main.getPrimaryStage()));
            while (s.hasNext())
            {
                String line = s.nextLine();
                if (line.contains("$"))
                {
                    String[] splitLine = line.split("\\s+");
                    for (String entry : splitLine)
                    {
                        if (entry.contains("$"))
                        {
                            textEditor.appendText("\t\t\t\t " + entry + "\n");
                        }
                        else
                        {
                            textEditor.appendText(entry + " ");
                        }
                    }
                }
                else if (line.contains("-"))
                {
                    textEditor.appendText("\t\t\t\t\t\t" + line.trim() + "\n");
                    System.out.println(line);
                }
                else if (line.contains("Amount"))
                {
                    String[] splitLine = line.split("\\s+");
                    textEditor.appendText(splitLine[0] + "\t\t\t" + splitLine[1] + "\t\t" + splitLine[2] + "\n");
                }
                else
                {

                    textEditor.appendText(line + "\n");
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        String path = System.getProperty("user.dir");
        FileWriter fos = new FileWriter(
            new File(path, "name.txt"));
        fos.write(textEditor.getText());
        fos.close();
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

