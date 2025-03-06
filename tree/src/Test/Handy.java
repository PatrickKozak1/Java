package Test;

import Test.Beobachter;

class Handy implements Beobachter {
    @Override
    public void aktualisiereWetter(String wetter) {
        System.out.println("Handy zeigt " + wetter +" C°");
    }
}