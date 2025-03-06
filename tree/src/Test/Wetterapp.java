package Test;

import Test.Handy;
import Test.Tv;

import java.util.Scanner;

public class Wetterapp {
    public static void main(String[] args) {
        WetterStation wetterStation = new WetterStation();
        Handy handy = new Handy();
        Tv tv = new Tv();

        wetterStation.registriereBeobachter(handy);
        wetterStation.registriereBeobachter(tv);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Geben Sie das Wetter ein (oder 'exit' zum Beenden): ");
            String wetter = scanner.nextLine();
            if (wetter.equalsIgnoreCase("exit")) {
                break;
            }
            wetterStation.setWetter(wetter);
        }
        scanner.close();
    }
}

