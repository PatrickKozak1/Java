package Test;

import Test.Beobachter;

import java.util.ArrayList;
import java.util.List;

class WetterStation {
    private List<Beobachter> beobachter;
    private String wetter;

    public WetterStation() {
        beobachter = new ArrayList<>();
    }

    public void registriereBeobachter(Beobachter beobachter) {
        this.beobachter.add(beobachter);
    }

    public void entferneBeobachter(Beobachter beobachter) {
        this.beobachter.remove(beobachter);
    }

    public void setWetter(String wetter) {
        this.wetter = wetter;
        benachrichtigeBeobachter();
    }

    private void benachrichtigeBeobachter() {
        for (Beobachter beobachter : beobachter) {
            beobachter.aktualisiereWetter(wetter);
        }
    }
}
