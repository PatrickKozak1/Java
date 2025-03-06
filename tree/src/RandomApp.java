public class RandomApp {
    public static void main(String[] args) {
        RandomModel model = new RandomModel();
        RandomView view = new RandomView();
        new RandomController(model, view);
        view.setVisible(true);
    }
}
