import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModelBearbeiten {
    private List<String> fragenListe = new ArrayList<>();
    private final String dateiName = "fragen.txt";

    public ModelBearbeiten() {
        loadFromFile();
    }

    public void loadFromFile() {
        fragenListe.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(dateiName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fragenListe.add(line);
            }
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
        fragenListe.add(frage);
        saveToFile();
    }

    public void removeFrage(int index) {
        if (index >= 0 && index < fragenListe.size()) {
            fragenListe.remove(index);
            saveToFile();
        }
    }

    public List<String> getFragenListe() {
        return fragenListe;
    }
}
