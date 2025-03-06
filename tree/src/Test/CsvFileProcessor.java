package Test;

import java.io.BufferedReader;
import java.io.IOException;


public class CsvFileProcessor extends TemplateMethodPattern {
    int number1;
    int number2;
    @Override
    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(";");
            number1=Integer.parseInt(numbers[0].replaceAll("[^0-9]"," ").trim());
            number2=Integer.parseInt(numbers[1].replaceAll("[^0-9]"," ").trim());
            System.out.println(number1 +"|"+number2+"|"+(number1+number2));
        }
    }
}

