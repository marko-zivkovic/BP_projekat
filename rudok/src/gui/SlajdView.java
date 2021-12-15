package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Cvorovi.Slot;
import Observer.ISubscriber;
import Observer.UpdateEvent;
import Observer.UpdateListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SlajdView extends JPanel implements ISubscriber, UpdateListener {
    Slajd slajd;
    Prezentacija prezz;
    ImagePanel panel;

    public SlajdView(Slajd ss, Prezentacija prez) {
        this.slajd = ss;
        this.prezz = prez;

        prez.addSubscriber(this);
        slajd.addSubscriber(this);
        this.setPreferredSize(new Dimension(300, 360));
        this.setLayout(new BorderLayout());
        System.out.println(prezz.getSlikatema());
        panel = new ImagePanel(prezz.getSlikatema());
        add(panel, BorderLayout.CENTER);
        this.addMouseListener(new MouseController());




    }

    @Override
    public void updatePerformed(UpdateEvent e) {
        repaint();
    }

    class ImagePanel extends JPanel {

        //private String slika;
        private Image img;

        public ImagePanel(String imag) {
            this.img = new ImageIcon(getClass().getResource(imag)).getImage();
        }

        public void setSlika(String slika) {
            //this.slika = slika;
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
        if(notification instanceof String && notification.equals("promena")){

            panel.setSlika(((Prezentacija)notification).getSlikatema());

        }
        else if (notification instanceof Slot){

                SlotView sv = new SlotView(((Slot)notification));
               // sv.paint(null);

        }
        else if(notification.equals(slajd)){
            this.removeAll();
            this.revalidate();
            this.repaint();
            System.out.println("USAPOPOPOOOOO)!23123123123123");
        }}



                           //MOUSEEVENT
        private class MouseController extends MouseAdapter {

            public void mousePressed(MouseEvent e) {

                if (e.getButton()==MouseEvent.BUTTON1){
                    Point position = e.getPoint();
                    int x = position.x;
                    int y = position.y;
                   // GeneralPath gp = new GeneralPath();
                    Paint fill = new Color(255,255,255);

                    Slot slot = new Slot(new BasicStroke(2f),x,y,50,100,fill);
                    slajd.addSlot(slot);
                    System.out.println("nigggaa");

                }
            }


        }

}
