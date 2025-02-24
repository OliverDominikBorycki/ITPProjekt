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
        shuffleWordsAndImages();
    }

    private void shuffleWordsAndImages() {
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

    public boolean addQuestion(String word, String[] images) {
        if (questionCount < words.length) {
            words[questionCount] = word;
            imageUrls[questionCount] = images;
            questionCount++;
            return true;
        }
        return false;
    }

    public boolean removeQuestion(int index) {
        if (index >= 0 && index < questionCount) {
            for (int i = index; i < questionCount - 1; i++) {
                words[i] = words[i + 1];
                imageUrls[i] = imageUrls[i + 1];
            }
            words[questionCount - 1] = null;
            imageUrls[questionCount - 1] = new String[4];
            questionCount--;
            return true;
        }
        return false;
    }

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
}
