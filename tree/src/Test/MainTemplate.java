package Test;

import Test.CommandInvoker;

import java.util.Scanner;

public class MainTemplate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandInvoker invoker = new CommandInvoker();

        System.out.println("Geben Sie 'csv' ein, um die Summe von zwei Spalten zu berechnen oder 'txt', um eine Textdatei zu lesen:");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("csv")) {
            System.out.println("Geben Sie den Pfad zur CSV-Datei ein:");
            String csvPath = scanner.nextLine();
            invoker.setCommand(new SumCsvCommand(csvPath));
        } else if (input.equalsIgnoreCase("txt")) {
            System.out.println("Geben Sie den Pfad zur TXT-Datei ein:");
            String txtPath = scanner.nextLine();
            invoker.setCommand(new ReadTxtCommand(txtPath));
        }

        invoker.executeCommand();
        scanner.close();
    }
}

