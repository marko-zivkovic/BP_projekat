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
import java.util.ArrayList;
import java.util.Iterator;

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
    ////////////imagepanel
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
    /////////////imagepanel
    @Override
    public void update(Object notification) {
        if (notification instanceof String && notification.equals("promena")) {

            panel.setSlika(((Prezentacija) notification).getSlikatema());

        } else if (notification instanceof Slot) {
            this.revalidate();
            this.repaint();

        }
        else if(notification.equals(slajd)){
            this.removeAll();
            this.revalidate();
            this.repaint();
            System.out.println("Obrisan slajd");
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //omogucava providnost elemenata prilikom njihovog preklapanja
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        ArrayList<Slot> slotovi = slajd.getSlotovi();
        for(Slot s: slotovi){

            SlotView sv = new SlotView(s);
            sv.paint(g2);

        }

        System.out.println("Izvršena paintComponent metoda view-a");
    }





    //MOUSEEVENT
        private class MouseController extends MouseAdapter {

            public void mousePressed(MouseEvent e) {

                if (e.getButton()==MouseEvent.BUTTON1){
                    Point position = e.getPoint();
                    int x = position.x;
                    int y = position.y;
                    //System.out.println(x+" "+y);

                    Paint fill = new Color(255,255,255);

                    Slot slot = new Slot(new BasicStroke(2f),x,y,50,100,fill);
                    slajd.addSlot(slot);
                    System.out.println("setovan slot");

                }
            }


        }

}
