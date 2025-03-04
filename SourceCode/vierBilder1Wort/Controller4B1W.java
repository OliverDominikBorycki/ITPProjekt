import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller4B1W {
    private Model4B1W model;
    private View4B1W view;

    /**
     * Konstruktor für den Controller.
     *
     * @param model Das Model, das die Spiellogik und Daten speichert.
     * @param view  Die View, die die Benutzeroberfläche darstellt.
     */

    public Controller4B1W(Model4B1W model, View4B1W view) {
        this.model = model;
        this.view = view;

        view.updateImages(model.getCurrentImages());
        view.updateScore(model.getScore());

        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        view.getRestartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        view.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showMainMenu();
            }
        });
    }

    /**
     * Behandelt die Überprüfung der Benutzereingabe.
     * Falls die Antwort richtig ist, wird ein Feedback gegeben und die nächste Frage geladen.
     * Falls die Antwort falsch ist, wird das Spiel zurückgesetzt.
     */
    private void handleSubmit() {
        String answer = view.getAnswer();


        if (model.checkAnswer(answer)) {
            view.setFeedback("Richtig! Gut gemacht!");
        } else {

            view.setFeedback("Leider falsch. Neustart erforderlich!");
            restartGame();
        }

        view.updateScore(model.getScore());
        view.clearAnswer();

        if (!model.hasNextWord()) {
            view.setFeedback("Spiel beendet! Dein Punktestand: " + model.getScore());
            view.getSubmitButton().setEnabled(false);
        } else {
            view.updateImages(model.getCurrentImages());
        }
    }

    /**
     * Startet das Spiel neu.
     * Setzt den Punktestand und die Frage zurück, mischt die Fragen neu und aktualisiert die Anzeige.
     */
    private void restartGame() {
        model.restartGame(); // Spiel zurücksetzen
        view.setFeedback("Spiel neu gestartet!");
        view.updateImages(model.getCurrentImages()); // Bilder für die erste Frage
        view.updateScore(model.getScore()); // Punktestand zurücksetzen
        view.getSubmitButton().setEnabled(true); // Submit-Button aktivieren
    }
}
