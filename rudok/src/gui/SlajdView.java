package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Observer.ISubscriber;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlajdView extends JPanel implements ISubscriber {
    Slajd slajd;
    Prezentacija prezz;
    //ImageIcon slika;
    //JLabel jslika;
    ImagePanel panel;

    public SlajdView(Slajd ss, Prezentacija pre) {
        this.slajd = ss;
        this.prezz = pre;
        pre.addSubscriber(this);

        System.out.println(prezz.getSlikatema());
        //slika = new ImageIcon(prezz.getSlikatema());
        //jslika = new JLabel(slika);
        panel = new ImagePanel(prezz.getSlikatema());
//        panel.setSize(100, 250);
//        panel.setPreferredSize(new Dimension(100, 250));
//        panel.setMinimumSize(new Dimension(100, 250));
//        panel.setMaximumSize(new Dimension(100, 250));
//        setSize(100, 250);
//        setPreferredSize(new Dimension(100, 250));
//        setMaximumSize(new Dimension(100, 250));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        setVisible(true);

        add(panel);

        // panel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    class ImagePanel extends JPanel {

        private String slika;
        private Image img;

        public ImagePanel(String imag) {
            this.img = new ImageIcon(imag).getImage();
        }

        public void setSlika(String slika) {
            this.slika = slika;
            this.img = new ImageIcon(slika).getImage();
            this.repaint();
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, (int) (this.getSize().getWidth() - img.getWidth(null)) / 2,
                    (int) (this.getSize().getHeight() - img.getHeight(null)) / 2, null);
        }

    }

    @Override
    public void update(Object notification) {
        if(notification instanceof String && !notification.equals("odstupi")){
           // slika = new ImageIcon(((Prezentacija)notification).getSlikatema());
            //this.removeAll();
           // panel = new ImagePanel(((Prezentacija)notification).getSlikatema());
            panel.setSlika(((Prezentacija)notification).getSlikatema());
            //add(panel,BorderLayout.CENTER);
            //this.revalidate();
           // this.repaint();
        }else if(notification.equals(slajd)){
            this.removeAll();
            this.revalidate();
            this.repaint();
            System.out.println("USAPOPOPOOOOO)!23123123123123");
        }


    }
}
