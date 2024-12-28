import java.net.URL;

public class Model4B1W {
    private String[] words = {"Aufwandsschätzung", "Meilenstein", "Vertragsgegenstand"};
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
            }
    };
    private int currentIndex = 0;
    private int score = 0;

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

    public String getCurrentWord() {
        return words[currentIndex];
    }

    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(words[currentIndex])) {
            score++;
            currentIndex++;
            return true;
        } else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public boolean hasNextWord() {
        return currentIndex < words.length;
    }
}
