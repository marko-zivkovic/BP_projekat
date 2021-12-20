package state;

import gui.MainWindow;
import gui.MojTabbedPane;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SlideShowState implements State{
    @Override
    public void setSlideShowState(PrezentacijaView pvv) {

        PrezentacijaView pv = pvv;

        pvv.getCentar().removeAll();
        pvv.getCentar().revalidate();
        pvv.getCentar().repaint();

        JPanel konteiner = new JPanel();
        JButton pred = new JButton("<");
        JButton sled = new JButton(">");
        JPanel prikaz = new JPanel();
        CardLayout cl = new CardLayout();
        prikaz.setPreferredSize(new Dimension(800,500));
        prikaz.setLayout(cl);
        konteiner.setLayout(new FlowLayout());
        konteiner.add(pred);
        konteiner.add(prikaz);
        konteiner.add(sled);

        pvv.getCentar().add(konteiner, BorderLayout.CENTER);
        for(SlajdView s: pv.getSlajdViews()){
            prikaz.add(s,s.getName());
        }
        pred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(prikaz);
                pvv.getCentar().revalidate();
                pvv.getCentar().repaint();
            }
        });
        sled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(prikaz);
                pvv.getCentar().revalidate();
                pvv.getCentar().repaint();
//
            }
        });

    }
}
