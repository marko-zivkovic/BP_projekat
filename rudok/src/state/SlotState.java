package state;

import gui.MojTabbedPane;
import gui.PrezentacijaView;
import gui.SlajdView;

import java.awt.event.MouseEvent;

public class SlotState implements State{
    SlajdView sv;

    public void setSv(SlajdView sv) {
        this.sv = sv;
    }

    @Override
    public void setSlideShowState(PrezentacijaView pv) {

    }

    @Override
    public void MousePressed(MouseEvent e) {

    }
}
