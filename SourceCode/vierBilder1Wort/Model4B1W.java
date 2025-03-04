import java.io.*;
import java.net.URL;
import java.util.Random;

public class Model4B1W {
    private String[] words = new String[10];  // Maximale Anzahl an Fragen
    private String[][] imageUrls = new String[10][4]; // 4 Bilder pro Frage
    private int questionCount = 0; // Anzahl der gespeicherten Fragen
    private int currentIndex = 0;
    private int score = 0;

    public Model4B1W() {
    }

    /**
     * Mischt die Reihenfolge der gespeicherten Fragen und Bilder zufällig,
     * um bei jedem Neustart eine neue Reihenfolge zu erhalten.
     */
    public void shuffleWordsAndImages() {
        Random random = new Random();
        for (int i = questionCount - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            String tempWord = words[i];
            words[i] = words[j];
            words[j] = tempWord;

            String[] tempImages = imageUrls[i];
            imageUrls[i] = imageUrls[j];
            imageUrls[j] = tempImages;
        }
    }
    /**
     * Gibt die aktuellen Bilder für die aktuelle Frage zurück.
     *
     * @return Ein Array mit vier URL-Objekten, die zu den Bildern gehören.
     */
    public URL[] getCurrentImages() {
        String[] urls = imageUrls[currentIndex];
        URL[] urlObjects = new URL[4];
        try {
            for (int i = 0; i < 4; i++) {
                urlObjects[i] = new URL(urls[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlObjects;
    }

    public String getCurrentWord() {
        return words[currentIndex];
    }

    /**
     * Überprüft, ob die eingegebene Antwort korrekt ist.
     * Falls ja, wird der Punktestand erhöht und zur nächsten Frage gewechselt.
     *
     * @param answer Die vom Benutzer eingegebene Antwort.
     * @return true, wenn die Antwort korrekt ist, sonst false.
     */
    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(words[currentIndex])) {
            score++;
            currentIndex++;
            return true;
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public boolean hasNextWord() {
        return currentIndex < questionCount;
    }

    /**
     * Lädt Fragen und Bilder aus einer Datei und speichert sie im internen Array.
     * Jede Zeile der Datei sollte im Format "Wort|Bild1,Bild2,Bild3,Bild4" vorliegen.
     *
     * @param filename Der Dateiname, aus dem die Fragen geladen werden sollen.
     * @return true, wenn das Laden erfolgreich war, sonst false.
     */
    public boolean loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            questionCount = 0;
            while ((line = br.readLine()) != null && questionCount < words.length) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    words[questionCount] = parts[0];
                    imageUrls[questionCount] = parts[1].split(",");
                    questionCount++;
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Speichert die aktuell geladenen Fragen in einer Datei.
     * Das Format jeder Zeile ist: "Wort|Bild1,Bild2,Bild3,Bild4".
     *
     * @param filename Der Name der Datei, in die gespeichert werden soll.
     * @return true, wenn das Speichern erfolgreich war, sonst false.
     */
    public boolean saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < questionCount; i++) {
                bw.write(words[i] + "|");

                // Manuelle Verkettung der URLs ohne String.join
                for (int j = 0; j < imageUrls[i].length; j++) {
                    bw.write(imageUrls[i][j]);
                    if (j < imageUrls[i].length - 1) {
                        bw.write(",");
                    }
                }

                bw.write("\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Startet das Spiel neu, setzt Punktestand und Index zurück
     * und mischt die Fragen erneut, um eine zufällige Reihenfolge zu erhalten.
     */
    public void restartGame() {
        currentIndex = 0;
        score = 0;
        shuffleWordsAndImages();
    }

}
