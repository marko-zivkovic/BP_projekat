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
        this.setPreferredSize(new Dimension(300, 360));
        this.setLayout(new BorderLayout());
        System.out.println(prezz.getSlikatema());
        //slika = new ImageIcon(prezz.getSlikatema());
        //jslika = new JLabel(slika);
        panel = new ImagePanel(prezz.getSlikatema());
        add(panel, BorderLayout.CENTER);

        // panel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    class ImagePanel extends JPanel {

        private String slika;
        private Image img;

        public ImagePanel(String imag) {
            this.img = new ImageIcon(getClass().getResource(imag)).getImage();
        }

        public void setSlika(String slika) {
            this.slika = slika;
            this.img = new ImageIcon(getClass().getResource(slika)).getImage();
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
