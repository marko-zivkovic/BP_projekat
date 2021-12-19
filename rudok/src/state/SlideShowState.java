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
    public void setSlideShowState(MojTabbedPane mtp) {

        PrezentacijaView pv = (PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent();

        MainWindow.getInstance().getDesni().remove(MainWindow.getInstance().getMojTabbedPane());
        MainWindow.getInstance().getDesni().revalidate();
        MainWindow.getInstance().getDesni().repaint();
        JPanel konteiner = new JPanel();
        JButton pred = new JButton("<");
        JButton sled = new JButton(">");
        JPanel prikaz = new JPanel();
        CardLayout cl = new CardLayout();
        prikaz.setPreferredSize(new Dimension(900,500));
        prikaz.setLayout(cl);
        konteiner.setLayout(new FlowLayout());
        konteiner.add(pred);
        konteiner.add(prikaz);
        konteiner.add(sled);

        MainWindow.getInstance().getDesni().add(konteiner,BorderLayout.CENTER);
        for(SlajdView s: pv.getSlajdViews()){
            prikaz.add(s,s.getName());
        }
        pred.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.previous(prikaz);
                MainWindow.getInstance().getDesni().revalidate();
                MainWindow.getInstance().getDesni().repaint();
            }
        });
        sled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.next(prikaz);
                MainWindow.getInstance().getDesni().revalidate();
                MainWindow.getInstance().getDesni().repaint();
            }
        });

    }
}
