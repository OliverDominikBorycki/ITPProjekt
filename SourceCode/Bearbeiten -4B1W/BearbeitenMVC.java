public class BearbeitenMVC {
    public static void main(String[] args) {
        ModelBearbeiten model = new ModelBearbeiten();
        ViewBearbeiten view = new ViewBearbeiten();
        new ControllerBearbeiten(model, view);
    }
}
