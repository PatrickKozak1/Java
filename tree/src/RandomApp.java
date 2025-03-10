public class RandomApp {
    public static void main(String[] args) {
        RandomModel model = new RandomModel();
        RandomView view = new RandomView();
        new RandomController(model, view);
        view.setVisible(true);
    }

    public static void String(){
        System.out.println("Hallo heute is Montag");
    }
}
