import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBearbeiten {
    private ModelBearbeiten model;
    private ViewBearbeiten view;

    public ControllerBearbeiten(ModelBearbeiten model, ViewBearbeiten view) {
        this.model = model;
        this.view = view;

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String neueFrage = view.getNeueFrage();
                if (!neueFrage.isEmpty()) {
                    model.addFrage(neueFrage);
                    view.updateFragenListe(model.getFragenListe());
                    view.clearInput();
                } else {
                    JOptionPane.showMessageDialog(view, "Bitte eine Frage eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedFrageIndex();
                if (index != -1) {
                    model.removeFrage(index);
                    view.updateFragenListe(model.getFragenListe());
                } else {
                    JOptionPane.showMessageDialog(view, "Bitte eine Frage auswählen!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getMainMenuButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainMenu();
                view.dispose();
            }
        });

        view.updateFragenListe(model.getFragenListe());
    }
}
