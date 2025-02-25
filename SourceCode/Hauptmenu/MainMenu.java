import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("4 Bilder 1 Wort - Hauptmenü");
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

        JButton startQuizButton = new JButton("Quiz starten");
        JButton exitButton = new JButton("Beenden");

        // Buttons mittig ausrichten
        startQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Aktion für den "Quiz starten"-Button
        startQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchQuiz(); // Quiz starten
            }
        });

        // Aktion für den "Beenden"-Button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Programm beenden
            }
        });
        JButton editQuestionsButton = new JButton("Fragen bearbeiten");

        // Aktion für den "Fragen bearbeiten"-Button
        editQuestionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControllerBearbeiten(new ModelBearbeiten(), new ViewBearbeiten());
                dispose(); // Hauptmenü schließen
            }
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Abstand
        panel.add(editQuestionsButton);

        // Abstand zwischen den Buttons
        panel.add(Box.createVerticalGlue());
        panel.add(startQuizButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Vertikaler Abstand
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

        View4B1W view = new View4B1W();
        new Controller4B1W(model, view);

        dispose(); // Hauptmenü schließen
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
