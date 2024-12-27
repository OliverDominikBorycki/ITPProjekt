import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller4B1W {
    private Model4B1W model;
    private View4B1W view;

    public Controller4B1W(Model4B1W model, View4B1W view) {
        this.model = model;
        this.view = view;

        view.updateImages(model.getCurrentImages());
        view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
        String answer = view.getAnswer();
        if (model.checkAnswer(answer)) {
            view.setFeedback("Richtig! Gut gemacht!");
        } else {
            view.setFeedback("Leider falsch. Versuch es nochmal!");
        }
        view.updateScore(model.getScore());
        view.clearAnswer();

        if (model.hasNextWord()) {
            view.updateImages(model.getCurrentImages());
        } else {
            view.setFeedback("Spiel beendet! Dein Punktestand: " + model.getScore());
            view.getSubmitButton().setEnabled(false);
        }
    }
}
