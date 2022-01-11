package state;

import gui.MojTabbedPane;
import gui.PrezentacijaView;

import java.awt.event.MouseEvent;

public interface State {
public void setSlideShowState(PrezentacijaView pv);
public void MousePressed(MouseEvent e);
}

