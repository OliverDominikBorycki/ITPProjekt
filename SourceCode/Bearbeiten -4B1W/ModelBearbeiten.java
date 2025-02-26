import java.io.*;

public class ModelBearbeiten {
    private String[] fragenListe = new String[0];
    private final String dateiName = "fragen.txt";

    public ModelBearbeiten() {
        loadFromFile();
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiName))) {
            String line;
            int count = 0;

            // Zähle die Zeilen für die Größe des Arrays
            while ((line = reader.readLine()) != null) {
                count++;
            }

            // Neues Array mit der richtigen Größe erstellen
            fragenListe = new String[count];

            // Datei erneut lesen und ins Array speichern
            reader.close();
            BufferedReader reader2 = new BufferedReader(new FileReader(dateiName));

            for (int i = 0; i < count; i++) {
                fragenListe[i] = reader2.readLine();
            }

            reader2.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dateiName))) {
            for (String frage : fragenListe) {
                writer.write(frage);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
    }

    public void addFrage(String frage) {
        // Neues Array mit +1 Platz erstellen
        String[] neu = new String[fragenListe.length + 1];

        // Manuelles Kopieren
        for (int i = 0; i < fragenListe.length; i++) {
            neu[i] = fragenListe[i];
        }

        // Neues Element hinzufügen
        neu[neu.length - 1] = frage;
        fragenListe = neu;

        saveToFile();
    }


    public String[] getFragenListe() {
        return fragenListe;
    }
    public void removeLetzteFrage() {
        if (fragenListe.length == 0) return;

        String[] neu = new String[fragenListe.length - 1];
        for (int i = 0; i < neu.length; i++) {
            neu[i] = fragenListe[i];
        }
        fragenListe = neu;
        saveToFile();
    }

}
