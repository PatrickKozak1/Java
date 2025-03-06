package Test2;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
public class SudokuView extends JFrame {
    private JTextField [][] inputGrid= new JTextField[9][9];
    private JLabel [][] solvedGrid = new JLabel[9][9];
    private JButton solveButton= new JButton("Lösung");
    private JButton resetButton= new JButton("Erneut");

    public SudokuView(){
        setTitle("SudokuSolver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        setLocationRelativeTo(null);

        JPanel mainPanel= new JPanel(new GridLayout(1,2,20,0));
        JPanel inputPanel= new JPanel(new GridLayout(9,9));
        JPanel solvedPanel=new JPanel(new GridLayout(9,9));

        for(int row=0;row<inputGrid.length;row++){
            for(int col=0;col<inputGrid.length;col++){
                inputGrid[row][col]=new JTextField();
                inputGrid[row][col].setHorizontalAlignment(JTextField.CENTER);
                inputGrid[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                int top=(row%3==0)?3:1;
                int left=(col%3==0)?3:1;
                int right=(col==8)?3:1;
                int bottom = (row==8)?3:1;
                inputGrid[row][col].setBorder(new MatteBorder(top,left,bottom,right,Color.black));
                inputPanel.add(inputGrid[row][col]);
            }
        }
        inputPanel.setBorder(BorderFactory.createTitledBorder("<HTML><BODY><FONT face=\"Arial\" size=\"8\">Eingabe</FONT></BODY></HTML>"));
        mainPanel.add(inputPanel);

        for(int row=0;row<solvedGrid.length;row++){
            for(int col=0;col<solvedGrid.length;col++){
                solvedGrid[row][col]=new JLabel("", SwingConstants.CENTER);
                solvedGrid[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                solvedGrid[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                solvedGrid[row][col].setOpaque(true);
                solvedGrid[row][col].setBackground(Color.WHITE);
                int top=(row%3==0)?3:1;
                int left=(col%3==0)?3:1;
                int right=(col==8)?3:1;
                int bottom = (row==8)?3:1;
                solvedGrid[row][col].setBorder(new MatteBorder(top,left,bottom,right,Color.black));
                solvedPanel.add(solvedGrid[row][col]);
            }
        }
        solvedPanel.setBorder(BorderFactory.createTitledBorder("<HTML><BODY><FONT face=\"Arial\" size=\"8\">Lösung</FONT></BODY></HTML>"));
        mainPanel.add(solvedPanel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(solveButton);
        buttonsPanel.add(resetButton);

        add(mainPanel,BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public JTextField[][] getInputGrid() {
        return inputGrid;
    }

    public JLabel[][] getSolvedGrid() {
        return solvedGrid;
    }

    public JButton getSolveButton() {
        return solveButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this,message,"Error",JOptionPane.ERROR_MESSAGE);
    }


}
