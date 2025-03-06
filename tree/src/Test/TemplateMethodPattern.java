package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class TemplateMethodPattern {
    Scanner sc= new Scanner(System.in);
    public final void readFiles() {
        System.out.println("Filepath: ");
        String file= sc.nextLine();
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            readFromFile(reader);
        }
        catch (IOException e){
            System.err.println("Error reading file: "+e.getMessage());
        }
    }
    public abstract void readFromFile(BufferedReader reader) throws IOException;
}
