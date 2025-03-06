package Test;

import Test.CommandPattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadTxtCommand implements CommandPattern {
    private String filePath;

    public ReadTxtCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}