package Test;

import Test.CommandPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SumCsvCommand implements CommandPattern {
    private String filePath;

    public SumCsvCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            double sum = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                sum += Double.parseDouble(values[0]) + Double.parseDouble(values[1]);
            }
            System.out.println("Die Summe der Spalten ist: " + sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}