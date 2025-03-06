package Test;

import Test.Beobachter;

class Tv implements Beobachter {
    @Override
    public void aktualisiereWetter(String wetter) {
        System.out.println("TV zeigt " + wetter +" C°");
    }
}