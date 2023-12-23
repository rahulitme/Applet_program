import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginLogoutPage {
    private JFrame frame;
    private JPanel loginPanel;
    private JPanel welcomePanel;
    private JButton loginButton;
    private JButton logoutButton;
    private JLabel welcomeLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginLogoutPage() {
        frame = new JFrame("Login and Logout Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginPanel = new JPanel();
        welcomePanel = new JPanel();

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());

        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new LogoutButtonListener());
        logoutButton.setEnabled(false);

        welcomeLabel = new JLabel();

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(logoutButton);

        frame.add(loginPanel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void fadeIn(JPanel panel) {
        float alpha = 0.0f;
        panel.setOpaque(true);
        panel.setBackground(new Color(255, 255, 255, Math.round(alpha * 255)));

        Timer timer = new Timer(20, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1.0f) {
                    alpha = 1.0f;
                    timer.stop();
                }
                panel.setBackground(new Color(255, 255, 255, Math.round(alpha * 255)));
            }
        });
        timer.start();
    }

    private void fadeOut(JPanel panel) {
        float alpha = 1.0f;
        panel.setOpaque(true);
        panel.setBackground(new Color(255, 255, 255, Math.round(alpha * 255)));

        Timer timer = new Timer(20, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha -= 0.05f;
                if (alpha <= 0.0f) {
                    alpha = 0.0f;
                    timer.stop();
                    panel.setVisible(false);
                }
                panel.setBackground(new Color(255, 255, 255, Math.round(alpha * 255)));
            }
        });
        timer.start();
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Simulating a simple login validation
            if (username.equals("user") && password.equals("password")) {
                fadeOut(loginPanel);
                welcomeLabel.setText("Welcome, " + username + "!");
                frame.add(welcomePanel);
                frame.setSize(300, 100);
                logoutButton.setEnabled(true);
                fadeIn(welcomePanel);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fadeOut(welcomePanel);
            loginPanel.setVisible(true);
            welcomeLabel.setText("");
            frame.setSize(300, 200);
            logoutButton.setEnabled(false);
            fadeIn(loginPanel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginLogoutPage());
    }
}
