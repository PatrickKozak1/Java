package Test2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class SudokuController {
    private final SudokuModel model = new SudokuModel();
    private final SudokuView view;
    int size=9;
    int [][] board= model.getBoard();
    public SudokuController(SudokuModel model, SudokuView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getSolveButton().addActionListener(e->solveSudoku());
        view.getResetButton().addActionListener(e->resetSudoku());
        registerTextFieldListeners();
    }
    private void registerTextFieldListeners() {
        JTextField [][]fields= view.getInputGrid();
        for(int row=0;row<fields.length;row++){
            for(int col=0;col< fields.length;col++){
                final int r=row, c=col;
                fields[row][col].getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        handleInputChange(r,c,fields);
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        fields[r][c].setForeground(Color.black);
                        handleInputChange(r,c,fields);
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        fields[r][c].setForeground(Color.black);
                        handleInputChange(r,c,fields);
                    }
                });
            }
        }
    }
    private void handleInputChange(int row, int col, JTextField[][]fields) {
        String text=fields[row][col].getText().trim();
        if(text.isEmpty()){
            model.setCell(row,col,0);
            return;
        }
        try{
            int num= Integer.parseInt(text);
            if(num<1||num>9){
                view.showError("Wrong number format  (1-9)");
                fields[row][col].setForeground(Color.red);
                return;
            }
            model.setCell(row,col,num);
            if(!isValidCell(row,col)){
                view.showError("Invalid input. Number already taken");
                fields[row][col].setForeground(Color.red);
                model.setCell(row,col,0);
            }
        }catch( NumberFormatException ex){
            view.showError("Not a number");
            fields[row][col].setForeground(Color.red);
        }
    }


    private void resetSudoku() {
        JTextField[][]inputGrid= view.getInputGrid();
        JLabel[][]solvedGrid= view.getSolvedGrid();
        for(int row=0;row<inputGrid.length;row++){
            for(int col=0;col<inputGrid.length;col++){
                inputGrid[row][col].setText("");
                solvedGrid[row][col].setText("");
                solvedGrid[row][col].setBackground(Color.white);
                model.setCell(row,col,0);
            }
        }
    }

    private void solveSudoku() {
        int[][]board = new int[9][9];
        JTextField[][]inputGrid= view.getInputGrid();
        for(int row=0;row< board.length;row++){
            for(int col=0;col< board.length;col++){
                String text=inputGrid[row][col].getText();
                board[row][col]= text.isEmpty()? 0: Integer.parseInt(text);
            }
        }
        model.setBoard(board);
        if(solve()){
            int[][]solvedBoard= model.getBoard();
            JLabel [][] solvedGrid= view.getSolvedGrid();
            for(int row=0;row< solvedBoard.length;row++){
                for(int col=0;col< solvedBoard.length;col++){
                    solvedGrid[row][col].setText(String.valueOf(solvedBoard[row][col]));
                    solvedGrid[row][col].setBackground(Color.white);
                }
            }
        }

        else{
            view.showError("No solution found");
        }
    }

    public boolean solve(){
        return solveHelper(0,0);
    }

    private boolean solveHelper(int row,int col){
        if(row==size)return true;
        if(col==size)return solveHelper(row+1,0);
        if(board[row][col]!=0)return solveHelper(row,col+1);

        for(int num=1; num <=9;num++){
            if(isValid(row,col,num)){
                board[row][col]=num;
                if(solveHelper(row,col+1))return true;
                board[row][col]=0;
            }
        }
        return false;

    }

    private boolean isValid(int row, int col, int num) {
        for(int i=0;i<size;i++){
            if(board[row][i]==num || board[i][col]==num) return false;
        }
        int boxRow=(row/3)*3;
        int boxCol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[boxRow+i][boxCol+j]==num) return false;
            }
        }
        return true;
    }
    public boolean isValidCell(int row, int col) {
        int num=board[row][col];
        if(num==0) return true;
        for(int i=0;i<size;i++){
            if(i!=col &&board[row][i]==num){
                return false;
            }
            if(i!=row &&board[i][col]==num){
                return false;
            }
        }
        int boxRow=(row/3)*3;
        int boxCol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int r=boxRow+i;
                int c=boxCol+j;
                if((r!=row||c!=col)&& board[r][c]==num) return false;
            }
        }
        return true;
    }
}


