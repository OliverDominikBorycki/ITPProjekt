import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("ITP-Lernplattform");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Zentriert das Fenster auf dem Bildschirm

        JPanel mainMenuPanel = createMainMenuPanel();

        add(mainMenuPanel);

        setVisible(true);
    }

    /**
     * Erstellt das Hauptmenü-Panel mit Buttons für verschiedene Aktionen.
     *
     * @return Das erstellte JPanel mit dem Hauptmenü.
     */
    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertikale Anordnung

        JLabel titleLabel = new JLabel("ITP-Lernplattform");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Schriftgröße und Stil setzen
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentrieren

        JButton startQuizButton = new JButton("4B1W");
        JButton editQuestionsButton = new JButton("Fragen bearbeiten (4B1W)");
        JButton exitButton = new JButton("Beenden");

        startQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editQuestionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        startQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchQuiz();
            }
        });

        editQuestionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControllerBearbeiten(new ModelBearbeiten(), new ViewBearbeiten());
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30))); // Abstand zur Überschrift
        panel.add(startQuizButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(editQuestionsButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(exitButton);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    /**
     * Startet das Spiel "4 Bilder 1 Wort", indem das Model, die View und der Controller initialisiert werden.
     * Falls eine Datei mit Fragen existiert, wird diese geladen und der Inhalt zufällig durchmischt.
     * Das Hauptmenü-Fenster wird anschließend geschlossen.
     */
    private void launchQuiz() {
        Model4B1W model = new Model4B1W();

        try {
            model.loadFromFile("fragen.txt"); // Datei mit den Fragen laden
        } catch (Exception e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        }
        model.shuffleWordsAndImages();
        View4B1W view = new View4B1W();
        new Controller4B1W(model, view);

        dispose();
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
