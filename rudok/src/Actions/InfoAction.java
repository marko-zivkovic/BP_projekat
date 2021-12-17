package Actions;

import gui.AboutInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractMyAction{

    public InfoAction (){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("slike\\iinfo.png"));
        putValue(SHORT_DESCRIPTION, "info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AboutInfo  aboutInfo = new AboutInfo();
    }
}
