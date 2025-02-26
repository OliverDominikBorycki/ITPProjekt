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
                    view.setFragenListe(model.getFragenListe()); // Direkte Übergabe des Arrays
                    view.clearInput();
                } else {
                    JOptionPane.showMessageDialog(view, "Bitte eine Frage eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getRemoveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getFragenListe().length > 0) {
                    model.removeLetzteFrage();
                    view.setFragenListe(model.getFragenListe()); // Aktualisierung in der View
                } else {
                    JOptionPane.showMessageDialog(view, "Keine Fragen zum Löschen!", "Fehler", JOptionPane.ERROR_MESSAGE);
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

        view.setFragenListe(model.getFragenListe()); // Initiale Befüllung
    }
}
