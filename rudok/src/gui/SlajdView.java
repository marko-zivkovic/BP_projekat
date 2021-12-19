package gui;

import Cvorovi.Prezentacija;
import Cvorovi.Slajd;
import Cvorovi.Slot;
import Observer.ISubscriber;
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

public class SlajdView extends JPanel implements ISubscriber {
    Slajd slajd;
    Prezentacija prezz;
    ImagePanel panel;
    PrezentacijaView prezV;
    Integer br;
    Paint fill;
    BasicStroke bs;

    public SlajdView(Slajd ss, Prezentacija prez) {

        this.slajd = ss;
        this.prezz = prez;
        this.br=ss.getBr();
        fill = new Color(255,255,255);
        bs = new BasicStroke(4);

        prezz.addSubscriber(this);
        slajd.addSubscriber(this);
        this.setPreferredSize(new Dimension(300, 360));
        this.setLayout(new BorderLayout());
        System.out.println(prezz.getSlikatema());
        panel = new ImagePanel(prezz.getSlikatema());
        add(panel, BorderLayout.CENTER);

        this.addMouseListener(new MouseController());


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
        else if(notification instanceof Slajd){
            System.out.println("Obrisan slajd");
            //prezV.getCentar().remove(br);
           // prezV.getCentar().repaint();
            //prezV.revalidate();
            this.removeAll();
            this.revalidate();
            this.repaint();

        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.panel.paintComponent(g);

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

                    Slot slot = new Slot(bs,x,y,50,100,fill);
                    slajd.addSlot(slot);
                    System.out.println("setovan slot");

                }
            }


        }

    public void setFill(Paint fill) {
        this.fill = fill;
    }

    public void setBs(Integer i) {
        this.bs = new BasicStroke(i);
    }

    public Slajd getSlajd() {
        return slajd;
    }
}
