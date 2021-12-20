package Actions;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditSlotAction extends AbstractMyAction{
    public EditSlotAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike/ss.jpg"));
        putValue(SHORT_DESCRIPTION, "Edit za slot");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
