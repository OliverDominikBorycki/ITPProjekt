import java.io.File;

public class Model4B1W {
    private String[] words = {"Aufwandschätzung", "Meilenstein"};
    private String[][] imagePaths = {
            {"C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Aufwandschätzung/Aufwand.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Aufwandschätzung/bürodaten.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Aufwandschätzung/schätzung.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Aufwandschätzung\\job-5382501_1280.jpg"},
            {"C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Meilenstein\\Meilenstein.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Meilenstein\\pokal.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Meilenstein\\meilenstein3.jpg", "C:\\Users\\olibo\\OneDrive\\Desktop\\Kleine Projekte\\ITPProjekt\\Meilenstein\\meilenstein2.jpg"}
    };
    private int currentIndex = 0;
    private int score = 0;

    public File[] getCurrentImages() {
        String[] paths = imagePaths[currentIndex];
        File[] files = new File[paths.length];
        for (int i = 0; i < paths.length; i++) {
            files[i] = new File(paths[i]);
        }
        return files;
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
