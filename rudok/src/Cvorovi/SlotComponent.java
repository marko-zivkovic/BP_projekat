package Cvorovi;

import gui.MainWindow;

public class SlotComponent {

    String text = null;
    String slika = null;

    private static SlotComponent instance = null;

    private SlotComponent() {}

    public static SlotComponent getInstance(){
        if(instance == null){
            instance = new SlotComponent();

        }
        return instance;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
