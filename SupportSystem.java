import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * This class implements a technical support system. It is the top level class
 * in this project. The support system communicates via text input/output in the
 * text terminal.
 * 
 * This class uses an object of class InputReader to read input from the user,
 * and an object of class Responder to generate responses. It contains a loop
 * that repeatedly reads input and generates output until the users wants to
 * leave.
 * 
 * @author Kenny Castro-Monroy
 * @version 2021.26.04
 */
public class SupportSystem {
    private InputReader reader;
    private Responder responder;

    /**
     * Creates a technical support system.
     */
    public SupportSystem() {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the technical support system. This will print a welcome message and
     * enter into a dialog with the user, until the user ends the dialog.
     */
    public void start() {
        // boolean finished = false;

        printWelcome();

        // while (!finished) {
        HashMap<String, String> input = reader.getInput();

        Set<String> keys = input.keySet();

        for (String key : keys) {
            System.out.println("Key[" + key + "]: " + input.get(key));
        }

        ArrayList<String> testKeys = new ArrayList<>();
        testKeys.add("crash");
        testKeys.add("crashes");
        if (keys.containsAll(testKeys)) {
            System.out.println("All keys were found!");
        } else {
            System.out.println("Some keys were not found!");
        }
        if (input.get(testKeys.get(0)).equals(input.get(testKeys.get(1)))) {
            System.out.println("All keys were given the correct value!");
        } else {
            System.out.println("Some keys were not given the correct value!");
        }
        // if (input.contains("bye")) {
        // finished = true;
        // } else {
        // String response = responder.generateResponse(input);
        // System.out.println(response);
        // }
        // }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome() {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye() {
        System.out.println("Nice talking to you. Bye...");
    }
}
