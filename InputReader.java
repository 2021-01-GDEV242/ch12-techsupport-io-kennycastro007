import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * InputReader reads typed text input from the standard text terminal. The text
 * typed by a user is then chopped into words, and a set of words is provided.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class InputReader {
    private Scanner reader;
    private BufferedReader fileReader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get("default.txt");
        try {
            fileReader = Files.newBufferedReader(path, charset);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file 'default.txt'");
            fileReader = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            fileReader = null;
        }
    }

    /**
     * Read a line of text from standard input (the text terminal), and return it as
     * a set of words.
     *
     * @return A set of Strings, where each String is one of the words typed by the
     *         user
     */
    public HashMap<String, String> getInput() {
        System.out.print("> "); // print prompt

        HashMap<String, String> words = new HashMap<>();

        try {
            String firstLine = fileReader.readLine();
            while (firstLine != null && !firstLine.equals("")) {
                ArrayList<String> keys = new ArrayList<>();
                String[] list = firstLine.trim().split(",");
                for (String key : list) {
                    keys.add(key.trim());
                }
                String value = "";
                String line = fileReader.readLine();
                while (line != null && !line.equals("")) {
                    value += line + " ";

                    line = fileReader.readLine();
                }

                for (String key : keys) {
                    words.put(key, value);
                }
                firstLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return words;
    }
}
