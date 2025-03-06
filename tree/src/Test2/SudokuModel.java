package Test2;

public class SudokuModel {
    private int [][] board;
    private static final int size=9;
    public SudokuModel(){
        board= new int[size][size];
    }

    public void setBoard(int [][] newBoard){
        for(int i=0;i<size;i++){
            System.arraycopy(newBoard[i],0,board[i],0,size);
        }
    }
    public int [][] getBoard(){
        return board;
    }

    public void setCell(int row, int col, int num) {
        board[row][col]=num;
    }
}
