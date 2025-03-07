import javax.swing.*;
import java.awt.*;

public class RandomView extends JFrame {
    private final JButton startBtn= new JButton("START");
    private final JButton stopBtn= new JButton("STOP");
    private final GraphPanel graphPanel = new GraphPanel();

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getStopBtn() {
        return stopBtn;
    }

    public GraphPanel getGraphPanel() {
        return graphPanel;
    }
    public RandomView(){
        setTitle("RandomGenerator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        graphPanel.setBackground(Color.white);
        JPanel buttonPanel=new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        add(graphPanel,BorderLayout.CENTER);
        add(buttonPanel,BorderLayout.SOUTH);
    }
}

