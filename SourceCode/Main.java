import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model4B1W model = new Model4B1W();

        try {
            model.loadFromFile("fragen.txt"); // Datei mit den Fragen laden
        } catch (Exception e) {
            System.out.println("Fehler beim Laden der Datei: " + e.getMessage());
        }

        View4B1W view = new View4B1W();
        new Controller4B1W(model, view);
    }
}

