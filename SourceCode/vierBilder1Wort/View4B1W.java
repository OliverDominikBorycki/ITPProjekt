import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class View4B1W extends JFrame {
    private JLabel[] imageLabels = new JLabel[4];
    private JTextField answerField = new JTextField(20);
    private JButton submitButton = new JButton("Antwort überprüfen");
    private JLabel feedbackLabel = new JLabel(" ");
    private JLabel scoreLabel = new JLabel("Punktestand: 0");
    private JButton restartButton = new JButton("Neustart");
    private JButton mainMenuButton = new JButton("Hauptmenü");

    public View4B1W() {
        setTitle("4 Bilder 1 Wort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Bilder-Panel
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < 4; i++) {
            imageLabels[i] = new JLabel();
            imageLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            imageLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            imagePanel.add(imageLabels[i]);
        }
        add(imagePanel, BorderLayout.CENTER);

        // Eingabe-Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Deine Antwort:"));
        inputPanel.add(answerField);
        inputPanel.add(submitButton);
        add(inputPanel, BorderLayout.SOUTH);

        // Feedback-Panel
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new BorderLayout());
        feedbackPanel.add(feedbackLabel, BorderLayout.CENTER);
        feedbackPanel.add(scoreLabel, BorderLayout.EAST);
        add(feedbackPanel, BorderLayout.NORTH);

        // Neustart und Hauptmenü Buttons
        JPanel controlPanel = new JPanel();
        controlPanel.add(restartButton);
        controlPanel.add(mainMenuButton);
        add(controlPanel, BorderLayout.EAST);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * Aktualisiert die angezeigten Bilder mit den übergebenen URLs.
     *
     * @param imageUrls Ein Array mit 4 Bild-URLs für die aktuelle Frage.
     */
    public void updateImages(URL[] imageUrls) {
        for (int i = 0; i < imageUrls.length; i++) {
            try {
                ImageIcon icon = new ImageIcon(imageUrls[i]);
                imageLabels[i].setIcon(icon);  // Bild setzen
                imageLabels[i].setText("");    // Text entfernen
            } catch (Exception e) {
                e.printStackTrace();  // Fehlerausgabe in der Konsole
                imageLabels[i].setIcon(null);
                imageLabels[i].setText("Bild konnte nicht geladen werden");
            }
        }
    }

    public String getAnswer() {
        return answerField.getText().trim();  // Eingabe aus dem Textfeld holen
    }

    public void clearAnswer() {
        answerField.setText("");  // Antwort zurücksetzen
    }

    public void setFeedback(String feedback) {
        feedbackLabel.setText(feedback);  // Feedback anzeigen
    }
    /**
     * Aktualisiert die Anzeige des Punktestands.
     *
     * @param score Der neue Punktestand, der angezeigt werden soll.
     */
    public void updateScore(int score) {
        scoreLabel.setText("Punktestand: " + score);  // Punktestand anzeigen
    }

    public JButton getSubmitButton() {
        return submitButton;  // Zugriff auf den Submit-Button
    }

    public JButton getRestartButton() {
        return restartButton;  // Zugriff auf den Neustart-Button
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;  // Zugriff auf den Hauptmenü-Button
    }
    /**
     * Wechselt zurück ins Hauptmenü, indem das aktuelle Fenster geschlossen und das Hauptmenü geöffnet wird.
     */
    public void showMainMenu() {
        // Hauptmenü anzeigen
        dispose(); // Schließt das aktuelle Fenster
        new MainMenu(); // Öffnet das Hauptmenüentiert!");
    }
}
