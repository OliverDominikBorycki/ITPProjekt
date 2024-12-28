import java.net.URL;
import java.util.Random;

public class Model4B1W {
    private String[] words = {"Aufwandsschätzung", "Meilenstein", "Vertragsgegenstand", "Trendanalyse"};
    private String[][] imageUrls = {
            {
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Aufwandschaetzung/Aufwand.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Aufwandschaetzung/buerodaten.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Aufwandschaetzung/zeitschaetzung.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Aufwandschaetzung/schaetzung.jpg?raw=true"
            },
            {
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Meilenstein/Meilenstein.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Meilenstein/meilenstein2.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Meilenstein/pokal.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Meilenstein/meilenstein3.jpg?raw=true"
            },
            {
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Vertragsgegenstand/genehmigt.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Vertragsgegenstand/handshake.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Vertragsgegenstand/vertrag2.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Vertragsgegenstand/vertrag.jpg?raw=true"
            },
            {
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Trendanalyse/trend.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Trendanalyse/trend2.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Trendanalyse/trend3.jpg?raw=true",
                    "https://github.com/OliverDominikBorycki/BilderRepository/blob/main/Trendanalyse/trend4.jpg?raw=true"
            }
    };

    private int currentIndex = 0;
    private int score = 0;

    public Model4B1W() {
        shuffleWordsAndImages();
    }

    // Methode, um Wörter und Bild-URLs zufällig zu mischen
    private void shuffleWordsAndImages() {
        Random random = new Random();
        for (int i = words.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Wörter tauschen
            String tempWord = words[i];
            words[i] = words[j];
            words[j] = tempWord;

            // Bilder tauschen
            String[] tempImages = imageUrls[i];
            imageUrls[i] = imageUrls[j];
            imageUrls[j] = tempImages;
        }
    }

    // Gibt die URLs der aktuellen Bilder zurück
    public URL[] getCurrentImages() {
        String[] urls = imageUrls[currentIndex];
        URL[] urlObjects = new URL[urls.length];
        try {
            for (int i = 0; i < urls.length; i++) {
                urlObjects[i] = new URL(urls[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlObjects;
    }

    // Gibt das aktuelle Wort zurück
    public String getCurrentWord() {
        return words[currentIndex];
    }

    // Überprüft die Antwort
    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(words[currentIndex])) {
            score++;
            currentIndex++;
            return true;
        } else {
            return false;
        }
    }

    // Gibt den aktuellen Punktestand zurück
    public int getScore() {
        return score;
    }

    // Prüft, ob noch Wörter verfügbar sind
    public boolean hasNextWord() {
        return currentIndex < words.length;
    }
}
