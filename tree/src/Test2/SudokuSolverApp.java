package Test2;

public class SudokuSolverApp {
    public static void main(String[] args) {
        SudokuModel model = new SudokuModel();
        SudokuView view = new SudokuView();
        new SudokuController(model, view);
    }
}
