package Actions;

import gui.MainWindow;
import gui.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class StartState extends AbstractMyAction{
    public StartState(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/play.png"));
        putValue(SHORT_DESCRIPTION, "POKRENI");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView pv = (PrezentacijaView) MainWindow.getInstance().getMojTabbedPane().getSelectedComponent();
        pv.Start();
    }
}
