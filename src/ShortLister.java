import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        Filter shortWordFilter = new ShortWordFilter();
        System.out.println("Please select a file");


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);
                selectedFile = chooser.getSelectedFile();

                try (Scanner scanner = new Scanner(selectedFile)) {
                    System.out.println("Short words from file " + selectedFile.getName() + ":");
                    System.out.println("----------------------------------------");


                    while (scanner.hasNext()) {
                        String word = scanner.next();

                        if (shortWordFilter.accept(word)) {
                            System.out.println(word);
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            } else {
                System.out.println("No file selected");
            }
        }
    }

