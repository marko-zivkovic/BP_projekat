package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;

import javax.swing.*;
import java.awt.*;

public class SlajdView extends JPanel {
    Slajd slajd;
    Prezentacija prezz;

    public SlajdView (Slajd ss, Prezentacija pre){
        this.slajd=ss;
        this.prezz=pre;
       // System.out.println(prezz.getSlikatema());
        ImageIcon slika = new ImageIcon(getClass().getResource(prezz.getSlikatema()));
        JLabel jslika = new JLabel(slika);

        setSize(550,550);
        setLayout(new BorderLayout());

        setVisible(true);

        add(jslika,BorderLayout.CENTER);
        jslika.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
