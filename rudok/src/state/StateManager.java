package state;

import gui.MainWindow;
import gui.MojTabbedPane;
import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateManager {

    private State currentState;

    private SlideShowState slideShowState;
    private SlotState slotState;

    public StateManager() {
        initStates();
    }

    private void initStates() {
       slideShowState = new SlideShowState();
       slotState = new SlotState();
        currentState = slotState;
    }

    public State getCurrent(){
        return currentState;
    }

    public void setSlotState(){
        if(currentState != slotState)
        {
            currentState = slotState;

        }

    }

    public void setSlideShowState(){
        MojTabbedPane mtp = MainWindow.getInstance().getMojTabbedPane();
        if(currentState != slideShowState)
        {
            currentState = slideShowState;
            //hvatamp pv
            PrezentacijaView pv = (PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent();

            MainWindow.getInstance().getDesni().remove(MainWindow.getInstance().getMojTabbedPane());
            MainWindow.getInstance().getDesni().revalidate();
            MainWindow.getInstance().getDesni().repaint();
            JPanel konteiner = new JPanel();
            JButton pred = new JButton("Predhodni");
            JButton sled = new JButton("Sledeci");
            JPanel prikaz = new JPanel();
            CardLayout cl = new CardLayout();
            prikaz.setLayout(cl);
            konteiner.setLayout(new FlowLayout());
            konteiner.add(pred);
            konteiner.add(prikaz);
            konteiner.add(sled);

            MainWindow.getInstance().getDesni().add(konteiner,BorderLayout.CENTER);
            int brojac = 0;
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
        else{
            currentState = slotState;
            MainWindow.getInstance().getDesni().removeAll();
            MainWindow.getInstance().getDesni().add(mtp,BorderLayout.CENTER);
            MainWindow.getInstance().getDesni().add(MainWindow.getInstance().getJjToolBar(), BorderLayout.NORTH);
            ((PrezentacijaView)mtp.getSelectedComponent()).obrisiView();
            ((PrezentacijaView)mtp.getSelectedComponent()).mojRepaint();
            MainWindow.getInstance().getDesni().revalidate();
            MainWindow.getInstance().getDesni().repaint();

;        }

    }

}
