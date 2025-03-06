package Test;

import Test.TemplateMethodPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class TxtFileProcessor extends TemplateMethodPattern {
    Scanner sc=new Scanner(System.in);
    @Override
    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);;
        }
    }
}
