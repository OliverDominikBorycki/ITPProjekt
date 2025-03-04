import javax.swing.*;
import java.awt.*;

public class ViewBearbeiten extends JFrame {
    private String[] fragenListe = new String[0]; // Einfaches Array für die Fragen
    private JTextArea fragenTextArea = new JTextArea(10, 50); // Textfeld zur Anzeige der Fragen

    private JTextField wortField = new JTextField(15);
    private JTextField bild1Field = new JTextField(30);
    private JTextField bild2Field = new JTextField(30);
    private JTextField bild3Field = new JTextField(30);
    private JTextField bild4Field = new JTextField(30);

    private JButton addButton = new JButton("Hinzufügen");
    private JButton removeButton = new JButton("Letztes Wort löschen");
    private JButton mainMenuButton = new JButton("Hauptmenü");

    /**
     * Konstruktor für die Bearbeitungsansicht.
     * Erstellt die GUI und das Layout.
     */
    public ViewBearbeiten() {
        setTitle("Fragen bearbeiten");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Textfeld zur Anzeige der Fragen
        fragenTextArea.setEditable(false);
        add(new JScrollPane(fragenTextArea), BorderLayout.CENTER);

        // Eingabefelder + Buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 5, 5));

        inputPanel.add(new JLabel("Wort:"));
        inputPanel.add(wortField);

        inputPanel.add(new JLabel("Bild 1 URL:"));
        inputPanel.add(bild1Field);

        inputPanel.add(new JLabel("Bild 2 URL:"));
        inputPanel.add(bild2Field);

        inputPanel.add(new JLabel("Bild 3 URL:"));
        inputPanel.add(bild3Field);

        inputPanel.add(new JLabel("Bild 4 URL:"));
        inputPanel.add(bild4Field);

        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);

        // Steuerungs-Buttons
        JPanel controlPanel = new JPanel();
        controlPanel.add(mainMenuButton);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Liest die eingegebene Frage und deren zugehörige Bild-URLs aus den Textfeldern
     * und gibt sie im entsprechenden Format zurück.
     *
     * @return Die neue Frage im Format "Wort|Bild1,Bild2,Bild3,Bild4"
     */
    public String getNeueFrage() {
        String wort = wortField.getText().trim();
        String bild1 = bild1Field.getText().trim();
        String bild2 = bild2Field.getText().trim();
        String bild3 = bild3Field.getText().trim();
        String bild4 = bild4Field.getText().trim();

        // Format wie gewünscht zurückgeben
        return wort + "|" + bild1 + "," + bild2 + "," + bild3 + "," + bild4;
    }
    /**
     * Löscht den Inhalt aller Eingabefelder, um eine neue Frage einzugeben.
     */
    public void clearInput() {
        wortField.setText("");
        bild1Field.setText("");
        bild2Field.setText("");
        bild3Field.setText("");
        bild4Field.setText("");
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


    /**
     * Aktualisiert die angezeigte Liste der Fragen im Textfeld.
     *
     * @param fragen Array mit den aktuellen Fragen.
     */

    public void setFragenListe(String[] fragen) {
        fragenTextArea.setText("");
        if (fragen.length == 0) return;

        String text = "";
        for (int i = 0; i < fragen.length; i++) {
            text += fragen[i] + "\n";
        }
        fragenTextArea.setText(text);
    }

}
