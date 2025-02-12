import vierBilder1Wort.Model4B1W;
import vierBilder1Wort.View4B1W;

public class Main {
    public static void main(String[] args) {
        Model4B1W model = new Model4B1W();
        View4B1W view = new View4B1W();
        new Controller4B1W(model, view);
    }
}
