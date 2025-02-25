import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewBearbeiten extends JFrame {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> fragenListe = new JList<>(listModel);
    private JTextField frageField = new JTextField(20);
    private JButton addButton = new JButton("Hinzufügen");
    private JButton removeButton = new JButton("Löschen");
    private JButton mainMenuButton = new JButton("Hauptmenü");

    public ViewBearbeiten() {
        setTitle("Fragen bearbeiten");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Liste mit Fragen
        add(new JScrollPane(fragenListe), BorderLayout.CENTER);

        // Eingabefeld + Buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Neue Frage:"));
        inputPanel.add(frageField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Steuerungs-Buttons
        JPanel controlPanel = new JPanel();
        controlPanel.add(removeButton);
        controlPanel.add(mainMenuButton);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public String getNeueFrage() {
        return frageField.getText().trim();
    }

    public void clearInput() {
        frageField.setText("");
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public int getSelectedFrageIndex() {
        return fragenListe.getSelectedIndex();
    }

    public void updateFragenListe(List<String> fragen) {
        listModel.clear();
        for (String frage : fragen) {
            listModel.addElement(frage);
        }
    }
}
