package helo;
import javax.swing.*;

public class hlo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Greeting Window");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null); // Center the window

        String input = JOptionPane.showInputDialog("Enter M, A, E, or N:");

        String message;
        switch (input.toLowerCase()) {
            case "m":
                message = "Good morning, A!";
                break;
            case "a":
                message = "Good afternoon, E!";
                break;
            case "e":
                message = "Good evening, N!";
                break;
            case "n":
                message = "Good night!";
                break;
            default:
                message = "Invalid input!";
                break;
        }

        JOptionPane.showMessageDialog(frame, message, "Greeting", JOptionPane.INFORMATION_MESSAGE);

        frame.dispose(); // Close the window when done
    }
}








