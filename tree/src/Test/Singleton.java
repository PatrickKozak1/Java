package Test;

public class Singleton {
    private static Singleton instance;
    private int idCounter = 1;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public int getNextId() {
        return idCounter++;
    }
}
