import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomModel {

    private final List<List<Integer>> seriesData= new ArrayList<>();
    private final List<Color> seriesColor = new ArrayList<>();
    private final Random r = new Random();
    public synchronized int addSeries(Color color){
        List<Integer>newSeries= new ArrayList<>();
        seriesData.add(newSeries);
        seriesColor.add(color);
        return seriesData.size()-1;
    }
    public synchronized void addRandomNumber(int seriesIndex) {
        if(seriesIndex<seriesData.size()) {
            List<Integer> series = seriesData.get(seriesIndex);
            series.add(r.nextInt(101));
        }
    }
    public synchronized List<List<Integer>> getSeriesData() {
        List<List<Integer>>copy=new ArrayList<>();
        for(List<Integer>series:seriesData){
            copy.add(new ArrayList<>(series));
        }
        return copy;
    }
    public List<Color> getSeriesColor() {
        return new ArrayList<>(seriesColor);
    }
}

