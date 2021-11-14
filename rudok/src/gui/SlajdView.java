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

        System.out.println(prezz.getSlikatema());
        slika = new ImageIcon(prezz.getSlikatema());
        jslika = new JLabel(slika);

        setSize(550,550);
        setLayout(new BorderLayout());

        setVisible(true);

        add(jslika,BorderLayout.CENTER);
        jslika.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof String && !notification.equals("odstupi")){
            slika = new ImageIcon(((Prezentacija)notification).getSlikatema());
            this.removeAll();
            jslika = new JLabel(slika);
            add(jslika,BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        }else if(notification.equals(slajd)){
            this.removeAll();
            this.revalidate();
            this.repaint();
            System.out.println("USAPOPOPOOOOO)!23123123123123");
        }


    }
}
