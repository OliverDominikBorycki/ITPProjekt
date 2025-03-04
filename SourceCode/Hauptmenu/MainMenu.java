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

        // Hauptmenü erstellen
        JPanel mainMenuPanel = createMainMenuPanel();

        // Hauptmenü anzeigen
        add(mainMenuPanel);

        setVisible(true);
    }

    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertikale Anordnung

        // Überschrift hinzufügen
        JLabel titleLabel = new JLabel("ITP-Lernplattform");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Schriftgröße und Stil setzen
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentrieren

        // Buttons erstellen
        JButton startQuizButton = new JButton("4B1W");
        JButton editQuestionsButton = new JButton("Fragen bearbeiten (4B1W)");
        JButton exitButton = new JButton("Beenden");

        // Buttons mittig ausrichten
        startQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        editQuestionsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);


        startQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchQuiz();
            }
        });

        // Aktion für den "Fragen bearbeiten"-Button
        editQuestionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControllerBearbeiten(new ModelBearbeiten(), new ViewBearbeiten());
                dispose();
            }
        });

        // Aktion für den "Beenden"-Button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Komponenten zum Panel hinzufügen
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
