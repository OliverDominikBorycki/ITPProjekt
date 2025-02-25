import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller4B1W {
    private Model4B1W model;
    private View4B1W view;

    public Controller4B1W(Model4B1W model, View4B1W view) {
        this.model = model;
        this.view = view;

        // Initiale Bilder und Punktestand laden
        view.updateImages(model.getCurrentImages());
        view.updateScore(model.getScore());

        // Submit-Button für Antworten
        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        // Neustart-Button
        view.getRestartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        // Hauptmenü-Button
        view.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMainMenu();
            }
        });
    }

    private void handleSubmit() {
        String answer = view.getAnswer();

        // Überprüfe, ob die Antwort richtig ist
        if (model.checkAnswer(answer)) {
            view.setFeedback("Richtig! Gut gemacht!");
        } else {
            // Bei falscher Antwort das Spiel neu starten
            view.setFeedback("Leider falsch. Neustart erforderlich!");
            restartGame();
        }

        // Punktestand aktualisieren und Eingabefeld leeren
        view.updateScore(model.getScore());
        view.clearAnswer();

        // Wenn keine weiteren Fragen mehr, das Spiel beenden
        if (!model.hasNextWord()) {
            view.setFeedback("Spiel beendet! Dein Punktestand: " + model.getScore());
            view.getSubmitButton().setEnabled(false);
        } else {
            // Nächste Frage vorbereiten
            view.updateImages(model.getCurrentImages());
        }
    }

    // Funktion, um das Spiel neu zu starten
    private void restartGame() {
        model.restartGame(); // Spiel zurücksetzen
        view.setFeedback("Spiel neu gestartet!");
        view.updateImages(model.getCurrentImages()); // Bilder für die erste Frage
        view.updateScore(model.getScore()); // Punktestand zurücksetzen
        view.getSubmitButton().setEnabled(true); // Submit-Button aktivieren
    }
}
