package gui;

import Cvorovi.SlotComponent;

import javax.swing.*;

public class TSlotH implements SlotHendler{
    String text;
    JLabel zapis;
    public TSlotH(SlotComponent sc){
        text = sc.getText();
    }


    @Override
    public void readComponent() {}

    @Override
    public void setContekt(int x, int y, int w, int h) {
        zapis = new JLabel(text);
        zapis.setLocation(x,y);
        zapis.setSize(w,h);
    }

    @Override
    public void paintImage() {

    }

    @Override
    public void format() {

    }
}
