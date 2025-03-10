import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class RandomController {
    private final RandomModel model;
    private final RandomView view;
    private static boolean doIt=false;



    public RandomController(RandomModel model, RandomView view){
        this.model=model;
        this.view=view;
        initController();
    }

    private void initController() {
        view.getStartBtn().addActionListener(e->startGraphic());
        view.getStopBtn().addActionListener(e->stopGraphic());
    }

    private void stopGraphic() {
       doIt=false;

    }

    private void startGraphic() {
        if(!doIt) doIt=true;
        int seriesIndex= model.addSeries(getRandomColor());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (doIt) {
                    model.addRandomNumber(seriesIndex);
                    updateGraph();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t.start();
    }

    private Color getRandomColor() {
        Random r= new Random();
        return new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
    }
    
    private void updateGraph(){
        SwingUtilities.invokeLater(()->{

            for(int i=0;i<model.getSeriesData().size();i++) {
                view.getGraphPanel().setSeriesData(model.getSeriesData(),model.getSeriesColor());
            }
        });
    }
}

