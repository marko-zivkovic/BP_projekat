package state;

import gui.PrezentacijaView;
import gui.SlajdView;

import javax.swing.*;
import java.awt.*;

public class SlideEditorState implements State {

    @Override
    public void setSlideShowState(PrezentacijaView pvv) {

        pvv.getCentar().removeAll();
        pvv.getCentar().revalidate();
        pvv.getCentar().repaint();
        for(SlajdView s : pvv.getSlajdViews()){

            SlajdView sv = new SlajdView(s.getSlajd(),pvv.getPr());
            sv.setMaximumSize(new Dimension(130,70));
            sv.setMinimumSize(new Dimension(130,70));
            sv.setPreferredSize(new Dimension(130,70));
            pvv.getLevo().removeAll();
            pvv.getLevo().add(sv);
            pvv.getLevo().add(Box.createVerticalStrut(20));

            pvv.getCentar().add(s);
            pvv.getCentar().add(Box.createVerticalStrut(10));
        }
        pvv.getCentar().revalidate();
        pvv.getCentar().repaint();

    }
}
