package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Observer.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class SlajdView extends JPanel implements ISubscriber {
    Slajd slajd;
    Prezentacija prezz;
    ImageIcon slika;
    JLabel jslika;

    public SlajdView (Slajd ss, Prezentacija pre){
        this.slajd=ss;
        this.prezz=pre;
        pre.addSubscriber(this);

       // System.out.println(prezz.getSlikatema());
        slika = new ImageIcon(getClass().getResource(prezz.getSlikatema()));
        jslika = new JLabel(slika);

        setSize(550,550);
        setLayout(new BorderLayout());

        setVisible(true);

        add(jslika,BorderLayout.CENTER);
        jslika.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void update(Object notification) {
        slika = new ImageIcon(getClass().getResource(((Prezentacija)notification).getSlikatema()));
        jslika = new JLabel(slika);

    }
}
