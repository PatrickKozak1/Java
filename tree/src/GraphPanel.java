
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private List<List<Integer>> seriesData;
    private List<Color> seriesColor;
    RandomModel model= new RandomModel();
    public void setSeriesData(List<List<Integer>> seriesData, List<Color> seriesColor) {
        this.seriesData=seriesData;
        this.seriesColor=seriesColor;
        repaint();
    }

    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        if(seriesData==null||seriesData.isEmpty()){

            return;
        }

        int width=getWidth();
        int height=getHeight();
        int yMax=100;
        int graphHeight=height-80;

        for(int sI=0;sI<seriesData.size();sI++) {
            List<Integer> serie = seriesData.get(sI);
            Color sColor = seriesColor.get(sI);

            int maxNumbers = Math.min(serie.size(), width / 10);
            int xStep = (width - 80) / maxNumbers;
            g.setColor(sColor);

            for (int i = 1; i < maxNumbers; i++) {
                int x1 = (i - 1) * xStep + 40;
                int x2 = i * xStep + 40;
                int value1 = serie.get(serie.size() - maxNumbers + i - 1);
                int value2 = serie.get(serie.size() - maxNumbers + i);
                int y1 = height - 40 - (value1 * graphHeight / yMax);
                int y2 = height - 40 - (value2 * graphHeight / yMax);
                g.setColor(Color.black);
                g.fillOval(x1 - 7 / 2, y1 - 7 / 2, 7, 7);
                g.setColor(sColor);

                g.drawLine(x1, y1, x2, y2);

            }

        }
        g.setColor(Color.black);
        g.drawLine(40, 40, 40, height - 40);
        g.drawLine(40, height - 40, width - 40, height - 40);
        g.fillPolygon(new int[]{30, 50, 40}, new int[]{40, 40, 20}, 3);
        g.fillPolygon(new int[]{width - 40, width - 40, width - 20}, new int[]{height - 50, height - 30, height - 40}, 3);
        for (int i = 40; i < width - 40; i += (width - 80) / 10) {
            g.drawLine(i, height - 45, i, height - 35);
        }
        for (int i = height - 40, j = 0; i > 40; i -= (height - 80) / 10, j += 10) {
            g.drawLine(35, i, 45, i);

            g.drawString(String.valueOf(j), 10, i);

        }
    }
}


