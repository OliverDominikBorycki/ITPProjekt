import javax.swing.*;
import java.awt.*;
import java.io.File;

public class View4B1W extends JFrame {
    private JLabel[] imageLabels = new JLabel[4];
    private JTextField answerField = new JTextField(20);
    private JButton submitButton = new JButton("Antwort überprüfen");
    private JLabel feedbackLabel = new JLabel(" ");
    private JLabel scoreLabel = new JLabel("Punktestand: 0");

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

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateImages(File[] imageFiles) {
        for (int i = 0; i < 4; i++) {
            if (imageFiles[i].exists()) {
                imageLabels[i].setIcon(new ImageIcon(imageFiles[i].getAbsolutePath()));
                imageLabels[i].setText(""); // Text entfernen, wenn das Bild geladen wurde
            } else {
                imageLabels[i].setIcon(null);
                imageLabels[i].setText("Bild nicht gefunden");
            }
        }
    }

    public String getAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public void setFeedback(String feedback) {
        feedbackLabel.setText(feedback);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Punktestand: " + score);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}